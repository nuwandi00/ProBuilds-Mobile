package com.example.kelineyt.activities

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kelineyt.R
import com.example.kelineyt.data.Tips
import com.example.kelineyt.data.requestmedicine
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UpdateTipsActivity: AppCompatActivity() {

    //initialization
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private lateinit var TipDocname: EditText
    private lateinit var TipsEditText: EditText
    private lateinit var btnTipsUpdate: Button
    private lateinit var btnTipsDelete: Button

    //declare variables and initialize to null
    var userDoctorNameTIP: String? = null
    var userTipsComment: String? = null
    var HealthTipsID: String? = null

    //@SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.update_healthtips)

        //obtain an instance of posted class
        auth = FirebaseAuth.getInstance()

        //call current user to get firebase object
        val user = auth.currentUser

        //database connection
        database = FirebaseDatabase.getInstance().getReference("HealthTips")

        //reference to UI components
        TipDocname = findViewById(R.id.doctor_Nameedts)
        TipsEditText = findViewById(R.id.health_tipsedts)
        btnTipsUpdate = findViewById(R.id.edt_tipsbtns)
        btnTipsDelete = findViewById(R.id.delete_tips3btnn)

        //access doctorname , tips passed along with intent and initialize
        val bundle: Bundle? = intent.extras
        userDoctorNameTIP = bundle?.getString("DoctorsName")
        userTipsComment = bundle?.getString("HealthyTips")
        HealthTipsID = bundle?.getString("tID")

        Log.d(TAG ,HealthTipsID.toString())

        //set the text of EditText
        TipDocname.setText(userDoctorNameTIP.toString())
        TipsEditText.setText(userTipsComment.toString())

        //update posts
        btnTipsUpdate.setOnClickListener {
            updateHealthTip()
        }

        //delete posts
        btnTipsDelete.setOnClickListener {
            deleteHealthTip()
        }
    }

    private fun deleteHealthTip() {
        //assign post ID to post variable
        val Tips = HealthTipsID.toString()

        //remove post from firebase realtime database
        database.child(Tips).removeValue()
            .addOnCompleteListener{
                Toast.makeText(this, "Tips Deleted" , Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Error" , Toast.LENGTH_SHORT).show()
            }

    }

    private fun updateHealthTip() {
        val Tips = HealthTipsID.toString()
        val userID : String = auth.currentUser?.uid.toString()
        val editDoctorNameTIP = TipDocname.text.toString()
        val editTipsComment = TipsEditText.text.toString()



        val updatedHealthyTips = Tips(userID , editDoctorNameTIP , editTipsComment )

        //update post from firebase realtime database
        database.child(Tips).setValue(updatedHealthyTips)
            .addOnCompleteListener{
                Toast.makeText(this , "Tips Updated" , Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this , "Error" , Toast.LENGTH_SHORT).show()
            }
    }

}


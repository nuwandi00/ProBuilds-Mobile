package com.example.kelineyt.fragments.shopping

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.kelineyt.R
import com.example.kelineyt.data.feedback
import com.example.kelineyt.data.requestmedicine
import com.example.kelineyt.util.RegisterValidation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [requestMedicine.newInstance] factory method to
 * create an instance of this fragment.
 */

//initialization
class requestMedicine : Fragment() {
    private lateinit var medicinename: EditText
    private lateinit var contactnumber: EditText
    private lateinit var email: EditText
    private lateinit var requestmedicine: Button
    private lateinit var auth: FirebaseAuth
    private lateinit var dbref: DatabaseReference



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        auth = FirebaseAuth.getInstance()
        dbref = FirebaseDatabase.getInstance().getReference("RequestMedicine")

        val view = inflater.inflate(R.layout.activity_requestmedicine, container, false)
        medicinename = view.findViewById(R.id.medname)
        contactnumber = view.findViewById(R.id.medcontact)
        email = view.findViewById(R.id.medemail)
        requestmedicine = view.findViewById(R.id.btn_request)


        requestmedicine.setOnClickListener {
            if (medicinename.text.isNotEmpty() && contactnumber.text.isNotEmpty() && email.text.isNotEmpty()) {
                setmedicine()
                findNavController().navigate(R.id.action_requestMedicine_to_requestMedicineListFragment)
            } else {
                Toast.makeText(activity, "Please fill input fields", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }


    private fun setmedicine() {
        val userID: String = auth.currentUser?.uid.toString()
        val medicine: String = medicinename.text.toString()
        val number: String = contactnumber.text.toString()
        val email: String = email.text.toString()

        if (!isValidEmail(email)) {
            Toast.makeText(activity, "Invalid email address", Toast.LENGTH_SHORT).show()
            return
        }

        if (number.length != 10) {
            Toast.makeText(activity, "Contact number should have 10 digits", Toast.LENGTH_SHORT).show()
            return
        }

        val uniqueID: String = UUID.randomUUID().toString()
        val requestMedicineDet = requestmedicine(userID, medicine, number, email)

        dbref.child(uniqueID).setValue(requestMedicineDet).addOnCompleteListener {
            Toast.makeText(activity, "Requested Medicine Added successfully", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(activity, "Error", Toast.LENGTH_LONG).show()
        }
    }

    private fun isValidEmail(email: String): Boolean {
        val pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(pattern.toRegex())
    }

}
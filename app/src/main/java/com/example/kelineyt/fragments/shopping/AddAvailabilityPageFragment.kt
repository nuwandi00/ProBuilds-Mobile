package com.example.kelineyt.fragments.shopping

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import com.example.kelineyt.R
import com.example.kelineyt.data.Scheduling
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddAvailabilityPageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddAvailabilityPageFragment : Fragment() {

    private lateinit var dName: EditText
    private lateinit var specility: EditText
    private lateinit var address: EditText
    private lateinit var date: EditText
    private lateinit var from: EditText
    private lateinit var to: EditText
    private lateinit var confirm: Button
    private lateinit var auth: FirebaseAuth
    private lateinit var dbref: DatabaseReference
//    private var param1: String? = null
//    private var param2: String? = null

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }


    private fun setConfirm() {
        var userID : String = auth.currentUser?.uid.toString()
        var sdName : String = dName.text.toString()
        var sspeciality : String = specility.text.toString()
        var sAddress : String = address.text.toString()
        var sDate : String = date.text.toString()
        var sFrom : String = from.text.toString()
        var sTo : String = to.text.toString()

        val uniqueID : String = UUID.randomUUID().toString()
        var schedulingDet = Scheduling( userID,sdName,sspeciality,sAddress,sDate,sFrom,sTo)

        dbref.child(uniqueID).setValue(schedulingDet).addOnCompleteListener{
            Toast.makeText(activity,"Availability Added successfully" , Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(activity,"Error",Toast.LENGTH_LONG).show()
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        auth = FirebaseAuth.getInstance()
        dbref =FirebaseDatabase.getInstance().getReference("Scheduling")
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.add_availability, container, false)
        dName = view.findViewById(R.id.docNameUpdate)
        specility = view.findViewById(R.id.SpecilityUpdate)
        address = view.findViewById(R.id.AddressUpdate)
        date = view.findViewById(R.id.DateUpdate)
        from = view.findViewById(R.id.FromUpdate)
        to = view.findViewById(R.id.toUpdate)
        confirm = view.findViewById(R.id.Update)

        // Inside onCreateView method

// Create a Calendar instance
        val calendar = Calendar.getInstance()

// Set OnClickListener for the date EditText
        date.setOnClickListener {
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            // Create a DatePickerDialog and set its OnDateSetListener
            val datePickerDialog = DatePickerDialog(requireContext(), { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                // Set the selected date in the date EditText
                val formattedDate = String.format("%02d-%02d-%d", dayOfMonth, month + 1, year)
                date.setText(formattedDate)
            }, year, month, day)

            // Show the DatePickerDialog
            datePickerDialog.show()
        }
        // Inside onCreateView method

// Set OnClickListener for the from EditText
        from.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            // Create a TimePickerDialog and set its OnTimeSetListener
            val timePickerDialog = TimePickerDialog(
                requireContext(),
                { _: TimePicker, hourOfDay: Int, minute: Int ->
                    // Set the selected time in the from EditText
                    val formattedTime = String.format("%02d:%02d", hourOfDay, minute)
                    from.setText(formattedTime)
                },
                hour,
                minute,
                true
            )

            // Show the TimePickerDialog
            timePickerDialog.show()
        }

// Set OnClickListener for the to EditText
        to.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            // Create a TimePickerDialog and set its OnTimeSetListener
            val timePickerDialog = TimePickerDialog(
                requireContext(),
                { _: TimePicker, hourOfDay: Int, minute: Int ->
                    // Set the selected time in the to EditText
                    val formattedTime = String.format("%02d:%02d", hourOfDay, minute)
                    to.setText(formattedTime)
                },
                hour,
                minute,
                true
            )

            // Show the TimePickerDialog
            timePickerDialog.show()
        }



        confirm.setOnClickListener {
            if(dName.text.isNotEmpty() && specility.text.isNotEmpty() && address.text.isNotEmpty() && date.text.isNotEmpty() && from.text.isNotEmpty() && to.text.isNotEmpty()) {
                setConfirm()
               //
             findNavController().navigate(R.id.action_addAvailabilityPageFragment_to_addAvailabilityListFragment)
            } else {
                Toast.makeText(activity,"Please fill input fields",Toast.LENGTH_SHORT).show()
            }

        }
        return view
    }

}
//
//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment AddAvailabilityPageFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            AddAvailabilityPageFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }param2
//    }
//}
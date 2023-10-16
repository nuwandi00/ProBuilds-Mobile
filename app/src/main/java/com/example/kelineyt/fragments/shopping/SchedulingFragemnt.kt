package com.example.kelineyt.fragments.shopping

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.kelineyt.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SchedulingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SchedulingFragment : Fragment() {
    private lateinit var addAvailability: Button
    private lateinit var viewAvailability: Button
    private lateinit var rating: Button
//    private var param1: String? = null
//    private var param2: String? = null

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.available_details, container, false)
        addAvailability = view.findViewById(R.id.adding)
        viewAvailability = view.findViewById(R.id.viewAva)
        rating = view.findViewById(R.id.rateUs)

        addAvailability.setOnClickListener {

            findNavController().navigate(R.id.action_schedulingFragment2_to_addAvailabilityPageFragment)
        }
        viewAvailability.setOnClickListener{
            findNavController().navigate(R.id.action_schedulingFragment2_to_addAvailabilityListFragment)
        }

        rating.setOnClickListener{
            findNavController().navigate(R.id.action_schedulingFragment2_to_ratingActivity)
        }

        return view

    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment SchedulingFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            SchedulingFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }





}
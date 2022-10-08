package com.example.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.myapp.databinding.FragmentFirstBinding
import java.lang.Double

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
//    private var _binding: FragmentFirstBinding? = null
//    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
//        _binding = FragmentFirstBinding.inflate(inflater, container, false)
//        val view = binding.root
        val view = inflater.inflate(R.layout.fragment_first, container, false)
//        val button = view.findViewById<Button>(R.id.send_button)
//        button.setOnClickListener {
//            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
//        }
        val button = view.findViewById<Button>(R.id.send_button)
        button.setOnClickListener {
            val name = view.findViewById<EditText?>(R.id.name).text.toString()
            val company_name  = view.findViewById<EditText?>(R.id.company_name).text.toString()
            val longitude  = view.findViewById<EditText?>(R.id.longitude).text.toString()
            val latitude  = view.findViewById<EditText?>(R.id.latitude).text.toString()

            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(name, company_name, longitude, latitude)

            view.findNavController().navigate(action)

        }

//        binding.sendButton.setOnClickListener {
//            val name = binding.name.text.toString()
//            val company_name = binding.companyName.text.toString()
//            val longitude = binding.longitude.text.toString()
//            val latitude = binding.latitude.text.toString()

//            val data = Data(name, company_name, longitude, latitude)

//            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(data)

//            findNavController().navigate(action)
//


        return view
    }
}
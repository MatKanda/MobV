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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val button = view.findViewById<Button>(R.id.send_button)
        button.setOnClickListener {
            val name = view.findViewById<EditText?>(R.id.name).text.toString()
            val company_name  = view.findViewById<EditText?>(R.id.company_name).text.toString()
            val longitude  = view.findViewById<EditText?>(R.id.longitude).text.toString()
            val latitude  = view.findViewById<EditText?>(R.id.latitude).text.toString()

            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(name, company_name, longitude, latitude)

            view.findNavController().navigate(action)

        }
        return view
    }
}
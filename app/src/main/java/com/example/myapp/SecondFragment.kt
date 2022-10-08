package com.example.myapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import java.lang.String
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
//    private var _binding: FragmentSecondBinding? = null
//    private val binding get() = _binding!!

    // get the arguments from the Registration fragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)
//        _binding = FragmentSecondBinding.inflate(inflater, container, false)
//        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args : SecondFragmentArgs by navArgs()
        val name = args.name
        val company_name = args.companyName
        val longitude = args.longitude
        val latitude = args.latitude

        // set the values to respective textViews
        view.findViewById<TextView>(R.id.header_name).text = name
        view.findViewById<TextView>(R.id.header_company_name).text = company_name

        view.findViewById<Button>(R.id.open_map).setOnClickListener {
            val geoUri =
                "http://maps.google.com/maps?q=loc:".plus(latitude).plus( ",").plus(longitude)
//            val uri = String.format(Locale.ENGLISH, "geo:%f,%f", latitude, longitude)
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri))
            context!!.startActivity(intent)
        }
    }

}

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
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PubDetail.newInstance] factory method to
 * create an instance of this fragment.
 */
class PubDetail : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pub_detail, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args : PubDetailArgs by navArgs()
        val name = args.name
        val longitude = args.longitude
        val latitude = args.latitude
        val openingHours = args.openingHours
        val outdoorSeating = args.outdoorSeating
        val website = args.website
        val position = args.positionToDetail

        view.findViewById<TextView>(R.id.pub_detail_name).text = name
        view.findViewById<TextView>(R.id.pub_detail_lat).text = latitude
        view.findViewById<TextView>(R.id.pub_detail_lon).text = longitude
        view.findViewById<TextView>(R.id.pub_detail_opening_hours).text = openingHours
        view.findViewById<TextView>(R.id.pub_detail_outdoor_seating).text = outdoorSeating
        view.findViewById<TextView>(R.id.pub_detail_website).text = website

        view.findViewById<Button>(R.id.pub_detail_map_button).setOnClickListener {
            val geoUri =
                "http://maps.google.com/maps?q=loc:".plus(latitude).plus( ",").plus(longitude)
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri))
            context!!.startActivity(intent)
        }

        view.findViewById<Button>(R.id.delete_pub_detail).setOnClickListener {
//            val action = PubDetailDirections.actionPubDetailToCompaniesList(position)
//            view.findNavController().navigate(action)
        }
    }
}
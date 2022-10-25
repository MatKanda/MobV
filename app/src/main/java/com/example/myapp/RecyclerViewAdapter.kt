package com.example.myapp

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.EditText
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import com.example.myapp.placeholder.PlaceholderContent.PlaceholderItem
import com.example.myapp.process_json.Affirmation
import com.example.myapp.process_json.Pub
import androidx.navigation.fragment.navArgs


class RecyclerViewAdapter(private val context: PubsClass, private val dataset: MutableList<Pub>, private val navigation: NavController)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.pub_name)
        val deleteButton : Button = view.findViewById(R.id.delete_button)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.fragment_companies_list, parent, false)

        return ViewHolder(adapterLayout)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val pub = dataset[position]
        holder.textView.text = pub.tags.get("name")

        holder.deleteButton.setOnClickListener {
            dataset.remove(dataset[position])
        }

        holder.textView.setOnClickListener{
            val name = pub.tags.get("name").orEmpty()
            val longitude = pub.lon
            val latitude = pub.lat
            var openingHours = ""
            var outdoorSeating = ""
            var website = ""

            if (pub.tags.get("opening_hours") != null) {
                openingHours = pub.tags.get("opening_hours")!!
            }else{
                openingHours = "Unknown"
            }
            if (pub.tags.get("outdoor_seating") != null) {
                outdoorSeating = pub.tags.get("outdoor_seating")!!
            }else{
                outdoorSeating = "Unknown"
            }
            if (pub.tags.get("website") != null) {
                website = pub.tags.get("website")!!
            }else{
                website = "Unknown"
            }

            val action = PubsClassDirections.actionCompaniesListToPubDetail(latitude, longitude, openingHours, outdoorSeating, website, name, position)
            navigation.navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return dataset.size;
    }

}

package com.example.myapp

import android.annotation.SuppressLint
import android.content.ClipData
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Button
import androidx.navigation.NavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.myapp.database.PubTable
import com.example.myapp.process_json.MySingleton
import com.example.myapp.process_json.Pub
import com.example.myapp.databinding.FragmentCompaniesListBinding


class RecyclerViewAdapter() : ListAdapter<PubTable,RecyclerViewAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(private var binding: FragmentCompaniesListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pubTable: PubTable) {
            binding.pubName.text = pubTable.pubName
            }
//        fun navigate(pubTable: PubTable){
//            binding.pubName.setOnClickListener {
//                val name = pubTable.pubName
//                val longitude = pubTable.longitude
//                val latitude = pubTable.latitude
//                var openingHours = ""
//                var outdoorSeating = ""
//                var website = ""
//
//                if (pubTable.opening_hours != null) {
//                    openingHours = pubTable.opening_hours
//                }else{
//                    openingHours = "Unknown"
//                }
//                if (pubTable.outdoor_Seating != null) {
//                    outdoorSeating = pubTable.outdoor_Seating
//                }else{
//                    outdoorSeating = "Unknown"
//                }
//                if (pubTable.website != null) {
//                    website = pubTable.website
//                }else{
//                    website = "Unknown"
//                }
//                val action = PubsClassFragmentDirections.actionCompaniesListToPubDetail(latitude, longitude, openingHours, outdoorSeating, website, name, position)
//                navigation.navigate(action)
//            }
//        }
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentCompaniesListBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)

//        navigate(getItem(position))
    }


    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<PubTable>() {
            override fun areItemsTheSame(oldItem: PubTable, newItem: PubTable): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: PubTable, newItem: PubTable): Boolean {
                return oldItem.pubName == newItem.pubName && oldItem.latitude == newItem.latitude && oldItem.longitude == newItem.longitude
                        && oldItem.website == newItem.website && oldItem.opening_hours == newItem.opening_hours && oldItem.outdoor_Seating == newItem.outdoor_Seating
            }
        }
    }

}

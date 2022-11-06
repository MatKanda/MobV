package com.example.myapp

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.database.PubTable
import com.example.myapp.databinding.FragmentCompaniesListBinding


class RecyclerViewAdapter(private val navigation: NavController) : ListAdapter<PubTable,RecyclerViewAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(private var binding: FragmentCompaniesListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pubTable: PubTable) {
            binding.pubName.text = pubTable.pubName
            }
        fun navigateToPubDetail(latitude:String, longitude:String,openingHours:String,outdoorSeating:String,website:String,name:String, navigation: NavController){
            binding.pubName.setOnClickListener {
                val action = PubsClassFragmentDirections.actionCompaniesListToPubDetail(latitude, longitude,openingHours,outdoorSeating,website,name)
                navigation.navigate(action)
            }
        }
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
        val currentPub = getItem(position)
        holder.bind(currentPub)
        holder.navigateToPubDetail(currentPub.latitude,currentPub.longitude,currentPub.opening_hours,currentPub.outdoor_Seating,currentPub.website,currentPub.pubName,navigation)

//        navigate(getItem(position))
    }


    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<PubTable>() {
            override fun areItemsTheSame(oldItem: PubTable, newItem: PubTable): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: PubTable, newItem: PubTable): Boolean {
                return oldItem.pubName == newItem.pubName
            }
        }
    }

}

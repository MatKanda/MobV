package com.example.myapp

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.EditText
import androidx.navigation.Navigation.findNavController

import com.example.myapp.placeholder.PlaceholderContent.PlaceholderItem
import com.example.myapp.process_json.Affirmation
import com.example.myapp.process_json.Pub

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class RecyclerViewAdapter(private val context: PubsClass, private val dataset: List<Pub>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.pub_name)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.fragment_companies_list, parent, false)

        return ViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val pub = dataset[position]
        holder.textView.text = pub.tags.get("name")
        holder.textView.setOnClickListener{
//            findNavController().navigate(R.id.action_companiesList_to_pubDetail)
        }
//        holder.textView.text =  context.resources.getString(pub.id.toInt())
    }

    override fun getItemCount(): Int {
        return dataset.size;
    }


}

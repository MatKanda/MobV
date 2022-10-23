package com.example.myapp

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.myapp.placeholder.PlaceholderContent.PlaceholderItem
import com.example.myapp.process_json.Pub

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class RecyclerViewAdapter(private val context: PubsClass, private val pubs: List<Pub>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_name)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
//        return ViewHolder(
//            FragmentCompaniesListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        )
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.fragment_companies_list, parent, false)

        return ViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = items[position]
//        holder.idView.text = item.id
//        holder.contentView.text = item.content

        val pub = pubs[position]
        holder.textView.text =  context.resources.getString(pub.id.toInt())
    }

    override fun getItemCount(): Int {
        return pubs.size;
    }


}
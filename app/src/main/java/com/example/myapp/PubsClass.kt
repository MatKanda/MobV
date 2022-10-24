package com.example.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.myapp.process_json.Datasource
import com.example.myapp.process_json.Pub
import com.example.myapp.process_json.Utils
import java.util.ArrayList

/**
 * A fragment representing a list of Items.
 */
class PubsClass : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pubs_class_list, container, false)

//        val myDataset = Datasource().loadAffirmations()
        val utils = Utils()
        val jsonFileName = "pubs.json"
        val jsonFileString = this.context?.let { utils.getJsonDataFromAsset(it, jsonFileName) }

        var allPubs:MutableList<Pub> = ArrayList()
        if (jsonFileString != null) {
            allPubs = utils.getJsonData(jsonFileString)
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = RecyclerViewAdapter(this, allPubs, findNavController())

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
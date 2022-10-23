package com.example.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapp.process_json.Pub
import com.example.myapp.process_json.Utils
import java.util.ArrayList

/**
 * A fragment representing a list of Items.
 */
class PubsClass : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val utils = Utils()
        val jsonFileName = "pubs.json"
        val jsonFileString = activity?.let { utils.getJsonDataFromAsset(it.getApplicationContext(), jsonFileName) }

        var allPubs:List<Pub> = ArrayList()
        if (jsonFileString != null) {
            allPubs = utils.getJsonData(jsonFileString)
        }
        System.out.println()

        val recyclerView = view?.findViewById<RecyclerView>(R.id.recycler_view)
        if (recyclerView != null) {
            recyclerView.adapter = RecyclerViewAdapter(this, allPubs)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_companies_list_list, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
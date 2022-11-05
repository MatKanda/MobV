package com.example.myapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp.database.view_model.PubApplication
import com.example.myapp.database.view_model.PubViewModel
import com.example.myapp.database.view_model.PubViewModelFactory
import com.example.myapp.process_json.MySingleton
import com.example.myapp.process_json.Pub
import com.example.myapp.databinding.FragmentPubsClassListBinding
/**
 * A fragment representing a list of Items.
 */
class PubsClassFragment : Fragment() {
    private val viewModel: PubViewModel by activityViewModels {
        PubViewModelFactory(
            (activity?.application as PubApplication).database.pubTableDao()
        )
    }

    private var _binding: FragmentPubsClassListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPubsClassListBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)

        var adapter = RecyclerViewAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.allPubs.observe(viewLifecycleOwner,Observer{
            pubs -> pubs?.let { adapter.submitList(it) }
        })


//        val view = inflater.inflate(R.layout.fragment_pubs_class_list, container, false)
//
//        view.findViewById<Button>(R.id.sort_button).setOnClickListener {
//            MySingleton.allPubs = MySingleton.allPubs.sortedByDescending{it.tags.get("name")}.reversed() as MutableList<Pub>
//            view.findNavController().navigate(R.id.action_companiesList_self)
//        }
        return binding.root
//        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
////        recyclerView.adapter = RecyclerViewAdapter(this, MySingleton.allPubs, findNavController())
//
//        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}
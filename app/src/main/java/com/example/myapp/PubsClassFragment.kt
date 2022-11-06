package com.example.myapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.myapp.database.view_model.PubApplication
import com.example.myapp.database.view_model.PubViewModel
import com.example.myapp.database.view_model.PubViewModelFactory
import com.example.myapp.databinding.FragmentPubsClassListBinding
/**
 * A fragment representing a list of Items.
 */
class PubsClassFragment : Fragment() {
    lateinit var swipeContainer: SwipeRefreshLayout

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

    @SuppressLint("MissingInflatedId", "NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPubsClassListBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)


        val adapter = RecyclerViewAdapter(findNavController())
        binding.recyclerView.adapter = adapter

        viewModel.allPubs.observe(viewLifecycleOwner,Observer{
            pubs -> pubs?.let { adapter.submitList(it) }
        })

        swipeContainer = binding.refreshLayout
        swipeContainer.setOnRefreshListener {
            viewModel.loadDataFromAPI()
            adapter.notifyDataSetChanged()
            swipeContainer.isRefreshing = false
        }
//        val view = inflater.inflate(R.layout.fragment_pubs_class_list, container, false)
//
//        view.findViewById<Button>(R.id.sort_button).setOnClickListener {
//            MySingleton.allPubs = MySingleton.allPubs.sortedByDescending{it.tags.get("name")}.reversed() as MutableList<Pub>
//            view.findNavController().navigate(R.id.action_companiesList_self)
//        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}
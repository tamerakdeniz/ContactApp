package com.example.contactapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.contactapp.R
import com.example.contactapp.data.entity.Kisiler
import com.example.contactapp.databinding.FragmentHomePageBinding
import com.example.contactapp.ui.adapter.ContactAdapter
import com.example.contactapp.ui.viewmodel.HomePageViewModel
import com.example.kisileruygulamasi.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    private lateinit var viewModel: HomePageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomePageBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener {
            // Navigation.findNavController(it).navigate(R.id.addContactTransition)
            Navigation.gecisYap(it,R.id.addContactTransition)
        }

        viewModel.kislerListesi.observe(viewLifecycleOwner) { //Dinleme
            val kisilerAdapter = ContactAdapter(requireContext(),it,viewModel)
            binding.kisilerRv.adapter = kisilerAdapter
        }

        binding.kisilerRv.layoutManager = LinearLayoutManager(requireContext()) // Alt Alta Sıralar

        // binding.kisilerRv.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL) - aynı düzeyde sağa doğru kaydırmalı

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean { //Harf girdikçe ve sildikçe çalışacak
                viewModel.ara(newText)
                return true

            }

            override fun onQueryTextSubmit(query: String): Boolean { //Arama butonuna basınca çalışacak
                viewModel.ara(query)
                return true
            }
        })

        return binding.root
    }

    fun ara(aramaKelimesi:String) {
        Log.e("Search Contact",aramaKelimesi)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:HomePageViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.kisileriYukle()
    }
}
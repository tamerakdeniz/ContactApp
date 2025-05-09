package com.example.contactapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.contactapp.R
import com.example.contactapp.data.entity.Kisiler
import com.example.contactapp.databinding.FragmentHomePageBinding
import com.example.contactapp.ui.adapter.ContactAdapter

class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomePageBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.addContactTransition)
        }

        val kisilerListesi = ArrayList<Kisiler>()
        val k1 = Kisiler(1,"Mustafa","1111")
        val k2 = Kisiler(2,"Tamer","2222")
        val k3 = Kisiler(3,"Akdeniz","3333")
        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)

        val kisilerAdapter = ContactAdapter(requireContext(),kisilerListesi)
        binding.kisilerRv.adapter = kisilerAdapter

        binding.kisilerRv.layoutManager = LinearLayoutManager(requireContext()) // Alt Alta Sıralar

        // binding.kisilerRv.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL) - aynı düzeyde sağa doğru kaydırmalı

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean { //Harf girdikçe ve sildikçe çalışacak
                ara(newText)
                return true

            }

            override fun onQueryTextSubmit(query: String): Boolean { //Arama butonuna basınca çalışacak
                ara(query)
                return true
            }
        })

        return binding.root
    }
    fun ara(aramaKelimesi:String) {
        Log.e("Search Contact",aramaKelimesi)
    }

    override fun onResume() {
        super.onResume()
        Log.e("Contact Home Page","returned")
    }
}
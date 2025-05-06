package com.example.contactapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.contactapp.R
import com.example.contactapp.data.entity.Kisiler
import com.example.contactapp.databinding.FragmentHomePageBinding

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

        binding.buttonDetail.setOnClickListener {
            val x = Kisiler(1,"Tamer","1111")
            val gecis = HomePageFragmentDirections.contactDetailTransition(kisi=x)
            Navigation.findNavController(it).navigate(gecis)
        }


        return binding.root
    }
}
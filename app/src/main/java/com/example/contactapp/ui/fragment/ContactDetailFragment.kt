package com.example.contactapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.contactapp.R
import com.example.contactapp.databinding.FragmentContactDetailBinding
import com.example.contactapp.databinding.FragmentHomePageBinding
import com.example.contactapp.ui.viewmodel.AddContactViewModel
import com.example.contactapp.ui.viewmodel.ContactDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactDetailFragment : Fragment() {
    private lateinit var binding: FragmentContactDetailBinding
    private lateinit var viewModel: ContactDetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactDetailBinding.inflate(inflater, container, false)

        val bundle: ContactDetailFragmentArgs by navArgs()
        val gelenKisi = bundle.kisi

        binding.editTextKisiAd.setText(gelenKisi.kisi_ad)
        binding.editTextKisiTel.setText(gelenKisi.kisi_tel)

        binding.buttonUpdate.setOnClickListener {
            val kisi_ad = binding.editTextKisiAd.text.toString()
            val kisi_tel = binding.editTextKisiTel.text.toString()
            viewModel.guncelle(gelenKisi.kisi_id,kisi_ad,kisi_tel)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: ContactDetailViewModel by viewModels()
        viewModel = tempViewModel
    }
}
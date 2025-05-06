package com.example.contactapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.contactapp.R
import com.example.contactapp.databinding.FragmentContactDetailBinding
import com.example.contactapp.databinding.FragmentHomePageBinding

class ContactDetailFragment : Fragment() {
    private lateinit var binding: FragmentContactDetailBinding
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

            guncelle(gelenKisi.kisi_id,kisi_ad,kisi_tel)
        }

        return binding.root
    }

    fun guncelle(kisi_id:Int,
                 kisi_ad:String,
                 kisi_tel:String) {
        Log.e("Kişi Güncelle","$kisi_id - $kisi_ad - $kisi_tel")
    }
}
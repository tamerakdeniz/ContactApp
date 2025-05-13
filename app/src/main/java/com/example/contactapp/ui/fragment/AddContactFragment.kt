package com.example.contactapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.contactapp.R
import com.example.contactapp.databinding.FragmentAddContactBinding
import com.example.contactapp.ui.viewmodel.AddContactViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddContactFragment : Fragment() {
    private lateinit var binding: FragmentAddContactBinding
    private lateinit var viewModel: AddContactViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddContactBinding.inflate(inflater, container, false)

        binding.buttonAdd.setOnClickListener {
            val kisi_ad = binding.editTextContactName.text.toString()
            val kisi_tel = binding.editTextContactNum.text.toString()
            viewModel.kaydet(kisi_ad, kisi_tel)
        }


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:AddContactViewModel by viewModels()
        viewModel = tempViewModel
    }


}
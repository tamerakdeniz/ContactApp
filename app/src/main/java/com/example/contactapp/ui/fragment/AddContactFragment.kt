package com.example.contactapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.contactapp.R
import com.example.contactapp.databinding.FragmentAddContactBinding

class AddContactFragment : Fragment() {
    private lateinit var binding: FragmentAddContactBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddContactBinding.inflate(inflater, container, false)

        binding.buttonAdd.setOnClickListener {
            val contact_name = binding.editTextContactName.text.toString()
            val contact_num = binding.editTextContactNum.text.toString()
            add(contact_name,contact_num)


        }


        return binding.root
    }

    fun add(contact_name: String, contact_num: String) {
        Log.e("Add Contact","$contact_name - $contact_num")
    }

}
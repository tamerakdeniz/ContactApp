package com.example.contactapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.data.entity.Kisiler
import com.example.contactapp.databinding.CardDesignBinding
import com.example.contactapp.ui.fragment.HomePageFragmentDirections
import com.example.contactapp.ui.viewmodel.HomePageViewModel
import com.example.kisileruygulamasi.utils.gecisYap
import com.google.android.material.snackbar.Snackbar


class ContactAdapter(var mContext: Context, var kisilerListesi:List<Kisiler>, var viewModel : HomePageViewModel)
    : RecyclerView.Adapter<ContactAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(var tasarim: CardDesignBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): CardTasarimTutucu {
        val tasarim = CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(tasarim)

    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kisi = kisilerListesi.get(position) // 0,1,2
        val t = holder.tasarim
        t.textViewAd.text = kisi.kisi_ad
        t.textViewTel.text = kisi.kisi_tel

        t.cardViewLine.setOnClickListener {
            val gecis = HomePageFragmentDirections.contactDetailTransition(kisi = kisi)
            // Navigation.findNavController(it).navigate(gecis)
            Navigation.gecisYap(it,gecis)
        }

        t.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"${kisi.kisi_ad} should it be deleted?", Snackbar.LENGTH_SHORT)
                .setAction("Yes") {
                    viewModel.sil(kisi.kisi_id)
                }.show()

        }
    }

    override fun getItemCount(): Int {
        return kisilerListesi.size

    }
}
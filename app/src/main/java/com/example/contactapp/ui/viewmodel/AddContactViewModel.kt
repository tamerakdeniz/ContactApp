package com.example.contactapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.contactapp.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddContactViewModel @Inject constructor(var kisilerRepository : KisilerRepository) : ViewModel(){
    fun kaydet(kisi_ad: String, kisi_tel: String) {
        CoroutineScope(Dispatchers.Main).launch { // Main arayüze yakın, görsel tasarım. IO veri tabanına yakın olan işlemsel yapılar
            kisilerRepository.kaydet(kisi_ad,kisi_tel)
        }

    }
}
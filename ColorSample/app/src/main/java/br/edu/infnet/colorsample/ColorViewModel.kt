package br.edu.infnet.colorsample

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class ColorViewModel: ViewModel() {
    val alias = MutableLiveData<String>()
    val colorCode = MutableLiveData<String>()

}
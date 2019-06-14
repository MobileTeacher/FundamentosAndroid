package br.edu.infnet.colorsample

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.edu.infnet.colorsample.model.MyColor

class MyColorViewModel: ViewModel() {
    val newColor = MutableLiveData<MyColor>()
}
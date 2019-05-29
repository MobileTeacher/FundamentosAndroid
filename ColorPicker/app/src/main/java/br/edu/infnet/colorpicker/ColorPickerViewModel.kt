package br.edu.infnet.colorpicker

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class ColorPickerViewModel: ViewModel() {

    var red = MutableLiveData<Int>().apply { value = 0 }
    var green = MutableLiveData<Int>().apply { value = 0 }
    var blue = MutableLiveData<Int>().apply { value = 0 }
    val color = MutableLiveData<Int>()

    init {
        red.observeForever { updateColor() }
        green.observeForever { updateColor() }
        blue.observeForever { updateColor() }
    }

    private fun  updateColor(){
        val red = red.value ?: 0
        val green = green.value ?: 0
        val blue = blue.value ?: 0
        color.value = (255 shl 24) + (red shl 16) +  (green shl 8) + blue
    }

}
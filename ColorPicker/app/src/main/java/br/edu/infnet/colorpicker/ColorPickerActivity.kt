package br.edu.infnet.colorpicker

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ColorPickerActivity : AppCompatActivity() {

    lateinit var colorPickerViewModel: ColorPickerViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_picker)

        // atenção, não instanciar o ViewModel por conta própria
        colorPickerViewModel = ViewModelProviders
                        .of(this)
                        .get(ColorPickerViewModel::class.java)
    }

}

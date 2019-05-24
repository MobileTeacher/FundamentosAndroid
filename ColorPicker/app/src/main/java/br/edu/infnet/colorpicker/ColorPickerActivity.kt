package br.edu.infnet.colorpicker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ColorPickerActivity : AppCompatActivity(), BarColorPickerFragment.ColorChangeListener {

    lateinit var colorFragment:ColorViewerFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_picker)

        val fragment = supportFragmentManager.findFragmentById(R.id.colorpicker_fragment)
        colorFragment = supportFragmentManager.findFragmentById(R.id.color_viewer_fragment) as ColorViewerFragment
//        val colorPickerFragment = fragment as? BarColorPickerFragment
//        colorPickerFragment?.setOnChangeColorListener(this)
        if (fragment is BarColorPickerFragment){
            fragment.setOnChangeColorListener(this)
        }

    }

    override fun onColorChange(red: Int, green: Int, blue: Int) {
        colorFragment.setColor(red, green, blue)
    }

}

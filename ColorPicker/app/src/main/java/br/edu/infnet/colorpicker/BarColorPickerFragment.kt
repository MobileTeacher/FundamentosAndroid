package br.edu.infnet.colorpicker


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import kotlinx.android.synthetic.main.fragment_bar_color_picker.*

/**
 * A simple [Fragment] subclass.
 *
 */
class BarColorPickerFragment : Fragment() {

    interface ColorChangeListener{
        fun onColorChange(red: Int, green: Int, blue: Int)
    }

    var colorChangeListener: ColorChangeListener? = null
    var redValue = 0
    var greenValue = 0
    var blueValue = 0


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bar_color_picker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //red_seekbar.setOnSeekBarChangeListener(onSeekBarChangeListener)
        val onSeekBarChangeListener = object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if (fromUser){
                    when(seekBar.id){
                        red_seekbar.id -> {
                            redValue = progress
                            red_value_textview.text = progress.toString()
                        }
                        green_seekbar.id -> {
                            greenValue = progress
                            green_value_textview.text = progress.toString()
                        }
                        blue_seekbar.id -> {
                            blueValue = progress
                            blue_value_textview.text = progress.toString()
                        }
                    }
                    colorChangeListener?.onColorChange(redValue, greenValue, blueValue)
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        }
        red_seekbar.setOnSeekBarChangeListener(onSeekBarChangeListener)
        green_seekbar.setOnSeekBarChangeListener(onSeekBarChangeListener)
        blue_seekbar.setOnSeekBarChangeListener(onSeekBarChangeListener)

    }

    fun setOnChangeColorListener(onChangeColorListener: ColorChangeListener){
        colorChangeListener = onChangeColorListener
    }


}

package br.edu.infnet.colorpicker


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
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

    lateinit var colorPickerViewModel: ColorPickerViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        activity?.let {
            colorPickerViewModel = ViewModelProviders
                    .of(it)
                    .get(ColorPickerViewModel::class.java)
        }
        return inflater.inflate(R.layout.fragment_bar_color_picker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val onSeekBarChangeListener = object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if (fromUser){
                    when(seekBar.id){
                        red_seekbar.id -> {
                            colorPickerViewModel.red.value = progress
                        }
                        green_seekbar.id -> {
                            colorPickerViewModel.green.value = progress
                        }
                        blue_seekbar.id -> {
                            colorPickerViewModel.blue.value = progress
                        }
                    }
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        }
        red_seekbar.setOnSeekBarChangeListener(onSeekBarChangeListener)
        green_seekbar.setOnSeekBarChangeListener(onSeekBarChangeListener)
        blue_seekbar.setOnSeekBarChangeListener(onSeekBarChangeListener)

        subscribe()
    }

    private fun subscribe(){
        colorPickerViewModel.red.observe(this,
                Observer {
                    it?.let { red_value_textview.text = "$it"}
                })
        colorPickerViewModel.green.observe(this,
                Observer {
                    it?.let { green_value_textview.text = "$it"}
                })
        colorPickerViewModel.blue.observe(this,
                Observer {
                    it?.let { blue_value_textview.text = "$it"}
                })
    }

}

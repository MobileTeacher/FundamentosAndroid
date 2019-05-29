package br.edu.infnet.colorpicker


import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_color_viewer.*


/**
 * A simple [Fragment] subclass.
 *
 */
class ColorViewerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color_viewer, container, false)
    }


    fun setColor(red:Int, green:Int, blue:Int){
        val color = (255 shl 24) + (red shl 16) +  (green shl 8) + blue

        color_view.setBackgroundColor(color)
    }


}

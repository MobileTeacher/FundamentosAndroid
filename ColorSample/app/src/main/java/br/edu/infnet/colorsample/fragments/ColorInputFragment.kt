package br.edu.infnet.colorsample.fragments


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.infnet.colorsample.ColorViewModel
import br.edu.infnet.colorsample.MyColorViewModel

import br.edu.infnet.colorsample.R
import br.edu.infnet.colorsample.model.MyColor
import kotlinx.android.synthetic.main.fragment_color_input.*

/**
 * A simple [Fragment] subclass.
 *
 */
class ColorInputFragment : Fragment() {

    private lateinit var colorViewModel: MyColorViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        activity?.let {
            colorViewModel = ViewModelProviders.of(it).get(MyColorViewModel::class.java)
        }

        return inflater.inflate(R.layout.fragment_color_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        save_button.setOnClickListener {
           val myColor = MyColor(alias_edittext.text.toString(),
                                    code_edittext.text.toString())
            colorViewModel.newColor.value = myColor
        }
    }


}

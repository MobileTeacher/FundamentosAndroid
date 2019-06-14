package br.edu.infnet.colorsample.fragments


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.infnet.colorsample.ColorViewModel

import br.edu.infnet.colorsample.R
import kotlinx.android.synthetic.main.fragment_color_show.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ColorShowFragment : Fragment() {

    private lateinit var colorViewModel: ColorViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        activity?.let {
            colorViewModel = ViewModelProviders.of(it).get(ColorViewModel::class.java)
        }
        return inflater.inflate(R.layout.fragment_color_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribe()
    }

    private fun subscribe(){
        colorViewModel.alias.observe(this, Observer {
            alias_textview.text = it ?: "Desconhecido"
        })

        colorViewModel.colorCode.observe(this, Observer {
            code_textview.text = it ?: "Desconhecido"
        })
    }


}

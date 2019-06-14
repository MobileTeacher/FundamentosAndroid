package br.edu.infnet.colorsample.fragments


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.infnet.colorsample.ColorAdapter
import br.edu.infnet.colorsample.MyColorViewModel

import br.edu.infnet.colorsample.R
import br.edu.infnet.colorsample.model.MyColor
import kotlinx.android.synthetic.main.fragment_color_list.*

/**
 * A simple [Fragment] subclass.
 *
 */

val initialColors = listOf<MyColor>(
        MyColor("873476", "Rubro"),
        MyColor("8A4B60", "Ouro")
)

class ColorListFragment : Fragment() {

    private lateinit var colorViewModel: MyColorViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        activity?.let {
            colorViewModel = ViewModelProviders.of(it).get(MyColorViewModel::class.java)
        }
        return inflater.inflate(R.layout.fragment_color_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
        subscribe()
    }

    private fun setUpRecyclerView(){
        activity?.let {
            color_list.adapter = ColorAdapter()
            color_list.layoutManager = LinearLayoutManager(it)
        }
    }

    private fun subscribe(){
        colorViewModel.newColor.observe(this, Observer {newColor->
            if (newColor != null){
                val colorAdapter = color_list.adapter as? ColorAdapter
                colorAdapter?.addColor(newColor)
            }
        })
    }


}

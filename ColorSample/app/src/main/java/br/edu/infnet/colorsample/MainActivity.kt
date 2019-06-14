package br.edu.infnet.colorsample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var colorViewModel: ColorViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        colorViewModel = ViewModelProviders.of(this)
                                .get(ColorViewModel::class.java)

        subscribe()
        setUpListeners()
    }

    private fun setUpListeners(){
        save_button.setOnClickListener {
            colorViewModel.alias.value = alias_edittext.text.toString()
            colorViewModel.colorCode.value = code_edittext.text.toString()
        }
    }

    private fun subscribe(){
        colorViewModel.alias.observe(this, Observer { value->
            if (value != null){
                alias_textview.text = value
            }
        })

        colorViewModel.colorCode.observe(this, Observer {value->
                code_textview.text = value ?: "desconhecido"
        })
    }
}

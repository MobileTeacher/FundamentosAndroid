package br.edu.infnet.baseconverter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val INVALID_ID = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        conversor_button.setOnClickListener{
            if (number_edittext.text.isNotEmpty()){
                val inputNumber = number_edittext.text.toInt()

                val inputId = input_radiogroup.checkedRadioButtonId
                val outputId = output_radiogroup.checkedRadioButtonId
                Log.d("MainActivity", "$inputId $outputId")
                if (inputId != INVALID_ID && outputId != INVALID_ID){

                    val inputBase = getBase(inputId)
                    val outputBase = getBase(outputId)

                    val result = convertBase(inputNumber, inputBase, outputBase)

                    result_textview.text = result
                } else {
                    Toast.makeText(this, "Selecione as bases!", Toast.LENGTH_LONG).show()
                }
            } else {
                // da uma resposta visual ao usuário

                number_edittext.error = "Campo vazio!"
            }
        }
    }

    fun getBase(id: Int) = when(id){
        R.id.in_bin, R.id.out_bin -> 2
        R.id.in_oct, R.id.out_oct -> 8
        R.id.in_dec, R.id.out_dec -> 10
        R.id.in_hex, R.id.out_hex -> 16
        else -> 0
    }

    fun convertBase(number: Int, from: Int, to: Int): String {
        //TODO: DO!
        return number.toString()
    }


}

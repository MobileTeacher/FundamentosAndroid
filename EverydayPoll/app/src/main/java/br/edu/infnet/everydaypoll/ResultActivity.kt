package br.edu.infnet.everydaypoll

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    val choices = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        choices.add(intent.getIntExtra(CHOICE0_EXTRA, 0))
        choices.add(intent.getIntExtra(CHOICE1_EXTRA, 0))
        choices.add(intent.getIntExtra(CHOICE2_EXTRA, 0))
        choices.add(intent.getIntExtra(CHOICE3_EXTRA, 0))
        choices.add(intent.getIntExtra(CHOICE4_EXTRA, 0))

        choice0_result_textview.text = "Ótimo: ${choices[0]}"
        choice1_result_textview.text = "Bom: ${choices[1]}"
        choice2_result_textview.text = "Regular: ${choices[2]}"
        choice3_result_textview.text = "Ruim: ${choices[3]}"
        choice4_result_textview.text = "Desastroso: ${choices[4]}"
    }
}

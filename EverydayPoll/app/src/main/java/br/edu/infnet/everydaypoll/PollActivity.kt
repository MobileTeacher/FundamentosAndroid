package br.edu.infnet.everydaypoll

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_poll.*

class PollActivity : AppCompatActivity() {

    val votes = mutableListOf<Int>(0, 0, 0, 0, 0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poll)


        answer_button.setOnClickListener {
            val selectedOptionId = poll_options_radiogroup.checkedRadioButtonId

            when(selectedOptionId){
                R.id.choice0 -> votes[0] += 1
                R.id.choice1 -> votes[1] += 1
                R.id.choice2 -> votes[2] += 1
                R.id.choice3 -> votes[3] += 1
                R.id.choice4 -> votes[4] += 1
            }
            //limpa o campo de email
            email_edittext.setText("")
            //limpa a escolha
            poll_options_radiogroup.clearCheck()

            Toast.makeText(this, "Resposta gravada!", Toast.LENGTH_LONG).show()
        }

        end_button.setOnClickListener {
            //abrir a tela de resultados
            val resultIntent = Intent(this, ResultActivity::class.java)

            resultIntent.putExtra(CHOICE0_EXTRA, votes[0])
            resultIntent.putExtra(CHOICE1_EXTRA, votes[1])
            resultIntent.putExtra(CHOICE2_EXTRA, votes[2])
            resultIntent.putExtra(CHOICE3_EXTRA, votes[3])
            resultIntent.putExtra(CHOICE4_EXTRA, votes[4])


            startActivity(resultIntent)
        }
    }
}

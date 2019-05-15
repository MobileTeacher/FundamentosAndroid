package br.edu.infnet.everydaypoll

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_poll.*
import kotlinx.android.synthetic.main.activity_result.*

class PollActivity : AppCompatActivity() {

    val NOT_SELECTED = -1
    val votes = mutableMapOf<String, Int>()

    val choicesCount: List<Int>
    get() {
        val choicesCount = mutableListOf(0, 0, 0, 0, 0)
        for ( (key, value) in votes){
            choicesCount[value] += 1
        }
        return  choicesCount
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poll)

        if (savedInstanceState != null){
            val mensagem = savedInstanceState.getString("Teste")
            Log.d("PollActivity", mensagem)
            email_edittext.setText(mensagem)
        } else{
            Toast.makeText(this, "NULO", Toast.LENGTH_SHORT).show()
        }

        setUpListeners()
    }

    fun setUpListeners(){
        answer_button.setOnClickListener {
            if (email_edittext.text.isNotEmpty()){
                val selectedOptionId = poll_options_radiogroup.checkedRadioButtonId
                if (selectedOptionId != NOT_SELECTED){
                    saveChoice(selectedOptionId)
                    //limpa o campo de email
                    email_edittext.setText("")
                    //limpa a escolha
                    poll_options_radiogroup.clearCheck()
                    Toast.makeText(this, "Resposta gravada!", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Selecione uma resposta!", Toast.LENGTH_LONG).show()
                }
            } else {
                email_edittext.error = "Campo obrigatório"
            }

        }

        end_button.setOnClickListener {
            //abrir a tela de resultados - intent explícita
            val resultIntent = Intent(this, ResultActivity::class.java)


            resultIntent.putExtra(CHOICE0_EXTRA, choicesCount[0])
            resultIntent.putExtra(CHOICE1_EXTRA, choicesCount[1])
            resultIntent.putExtra(CHOICE2_EXTRA, choicesCount[2])
            resultIntent.putExtra(CHOICE3_EXTRA, choicesCount[3])
            resultIntent.putExtra(CHOICE4_EXTRA, choicesCount[4])

            resultIntent.putExtra(QUESTION_EXTRA,  question_textview.text)
            resultIntent.putExtra(ADDRESSES_EXTRA, votes.keys.toTypedArray())


            startActivity(resultIntent)
        }
    }

    fun saveChoice(selectedOptionId: Int){
        val currentEmail = email_edittext.text.toString()
        votes[currentEmail] = when(selectedOptionId){
            R.id.choice0 -> 0
            R.id.choice1 -> 1
            R.id.choice2 -> 2
            R.id.choice3 -> 3
            R.id.choice4 -> 4
            else -> NOT_SELECTED
        }

    }


    override fun onStop() {
        super.onStop()
        val bundle = Bundle()
        bundle.putString("Teste", "Mensagem Oculta")
        onSaveInstanceState(bundle)
    }
}

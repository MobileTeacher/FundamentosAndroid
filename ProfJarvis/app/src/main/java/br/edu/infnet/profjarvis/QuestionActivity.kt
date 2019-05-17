package br.edu.infnet.profjarvis

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {


    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        //index = intent.getIntExtra("Index", 0)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        // faz operações com fragmentos
        fragmentTransaction.add(R.id.container, QuestionFragment())
        fragmentTransaction.commit()

        setUpListeners()
    }

    fun setUpListeners(){
//        answer_button.setOnClickListener {
//            val selectedOptionId = choices_radiogroup.checkedRadioButtonId
//            val selectedIndex = radioButtonsIds.indexOf(selectedOptionId)
//            if (selectedIndex == questions[index].answer){
//                Toast.makeText(this, "Parabéns, você acertou!", Toast.LENGTH_LONG).show()
//            } else {
//                Toast.makeText(this, ":( você errou!", Toast.LENGTH_LONG).show()
//            }
//
//            val nextIntent = Intent(this, QuestionActivity::class.java)
//            nextIntent.putExtra("Index", index+1)
//            startActivity(nextIntent)
//        }
    }





}

package br.edu.infnet.profjarvis

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {

    lateinit var question: Question
    lateinit var radioButtonsIds: List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val optionsArray = resources.getStringArray(R.array.test_choices)
        question = Question(getString(R.string.test_question),
                optionsArray.toList(),
                2)

        radioButtonsIds = listOf(choice_a_radiobutton.id,
                                choice_b_radiobutton.id,
                                choice_c_radiobutton.id,
                                choice_d_radiobutton.id)


        setUpQuestion(question)
        setUpListeners()
    }

    fun setUpListeners(){
        answer_button.setOnClickListener {
            val selectedOptionId = choices_radiogroup.checkedRadioButtonId
            val selectedIndex = radioButtonsIds.indexOf(selectedOptionId)
            if (selectedIndex == question.answer){
                Toast.makeText(this, "Parabéns, você acertou!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, ":( você errou!", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun setUpQuestion(question: Question){

        question_textview.text = question.body
        for (i in question.options.indices){
            findViewById<RadioButton>(radioButtonsIds[i]).text = question.options[i]
        }
    }



}

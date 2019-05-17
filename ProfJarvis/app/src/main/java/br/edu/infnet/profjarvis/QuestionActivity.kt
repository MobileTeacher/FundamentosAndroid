package br.edu.infnet.profjarvis

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {

    lateinit var questions: List<Question>
    lateinit var radioButtonsIds: List<Int>
    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        index = intent.getIntExtra("Index", 0)


        val optionsArray = resources.getStringArray(R.array.test_choices)
        questions = listOf(
                Question(getString(R.string.test_question),
                optionsArray.toList(),
                2),
                Question(getString(R.string.test_question2),
                        listOf("setClickListener",
                                "setOnClickListener",
                                "setClickSpeaker",
                                "setOnClickSpeaker"),
                        1))

        radioButtonsIds = listOf(choice_a_radiobutton.id,
                                choice_b_radiobutton.id,
                                choice_c_radiobutton.id,
                                choice_d_radiobutton.id)


        setUpQuestion(questions[index])
        setUpListeners()
    }

    fun setUpListeners(){
        answer_button.setOnClickListener {
            val selectedOptionId = choices_radiogroup.checkedRadioButtonId
            val selectedIndex = radioButtonsIds.indexOf(selectedOptionId)
            if (selectedIndex == questions[index].answer){
                Toast.makeText(this, "Parabéns, você acertou!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, ":( você errou!", Toast.LENGTH_LONG).show()
            }

            val nextIntent = Intent(this, QuestionActivity::class.java)
            nextIntent.putExtra("Index", index+1)
            startActivity(nextIntent)
        }
    }

    fun setUpQuestion(question: Question){

        question_textview.text = question.body
        for (i in question.options.indices){
            findViewById<RadioButton>(radioButtonsIds[i]).text = question.options[i]
        }
    }



}

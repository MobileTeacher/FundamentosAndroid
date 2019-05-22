package br.edu.infnet.profjarvis

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {

    val TAG = "QuestionActivity"
    lateinit var questions: List<Question>
    var currentQuestionIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

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

        // para operar com fragments
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val questionFragment = QuestionFragment.newInstance(questions[currentQuestionIndex])
        fragmentTransaction.add(R.id.container, questionFragment)
        fragmentTransaction.commit()

        setUpListeners()

    }

    fun setUpListeners(){
        answer_button.setOnClickListener {
            val choicesRadioGroup = findViewById<RadioGroup>(R.id.choices_radiogroup)
            val selectedOptionId = choicesRadioGroup.checkedRadioButtonId
            //val selectedIndex = radioButtonsIds.indexOf(selectedOptionId)
            val selectedRadioButton = findViewById<RadioButton>(selectedOptionId)
            val answerText = questions[currentQuestionIndex].options[questions[currentQuestionIndex].answer]
            val selectedText = selectedRadioButton.text.toString()
            Log.d(TAG, "$answerText x $selectedText")
            if (answerText == selectedText){
                Toast.makeText(this, "Parabéns, você acertou!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, ":( você errou!", Toast.LENGTH_LONG).show()
            }

          showNextQuestion()

        }
    }

    fun showNextQuestion(){
        currentQuestionIndex += 1
        if (currentQuestionIndex < questions.size){
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            val questionFragment = QuestionFragment.newInstance(questions[currentQuestionIndex])
            fragmentTransaction.replace(R.id.container, questionFragment)
            fragmentTransaction.commit()
        } else {
            // TODO: abrir fragmento de resultados
            Toast.makeText(this, "Acabaram as perguntas", Toast.LENGTH_LONG).show()
        }
    }

}

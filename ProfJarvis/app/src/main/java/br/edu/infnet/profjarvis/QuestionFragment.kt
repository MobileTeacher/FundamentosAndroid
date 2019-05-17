package br.edu.infnet.profjarvis


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import kotlinx.android.synthetic.main.fragment_question.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class QuestionFragment : Fragment() {

    lateinit var questions: List<Question>
    lateinit var radioButtonsIds: List<Int>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
    }

    fun setUpQuestion(question: Question){

        question_textview.text = question.body
        for (i in question.options.indices){
            activity?.findViewById<RadioButton>(radioButtonsIds[i])?.text = question.options[i]
        }
    }

}

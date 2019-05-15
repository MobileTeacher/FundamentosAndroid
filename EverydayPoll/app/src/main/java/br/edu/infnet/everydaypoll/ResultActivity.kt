package br.edu.infnet.everydaypoll

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    val choices = mutableListOf<Int>()
    val TAG = "ResultActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
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

        setUpListeners()
    }

    fun setUpListeners(){
        send_button.setOnClickListener{
            val addresses = intent.getStringArrayExtra(ADDRESSES_EXTRA)
            val question = intent.getStringExtra(QUESTION_EXTRA)
            composeEmail(addresses, question)
        }

    }

    fun composeEmail(addresses: Array<String>, question: String){
        val emailIntent = Intent(Intent.ACTION_SEND)
        //emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.type = "*/*"
        val emailBody = """Olá,
            Você está recebendo este email, porque participou da enquente "${question}".
                Segue abaixo o resultado:
                Ótimo: ${choices[0]}
                Bom: ${choices[1]}
                Regular: ${choices[2]}
                Ruim: ${choices[3]}
                Desastroso: ${choices[4]}

                Att, """
        emailIntent.putExtra(Intent.EXTRA_EMAIL, addresses)
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Resultado: $question")
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailBody)

        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);
        } else {
            Toast.makeText(this, "Sem app", Toast.LENGTH_LONG).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

}

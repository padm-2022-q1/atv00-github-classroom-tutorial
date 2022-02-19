package br.edu.ufabc.githubclassroomtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        findViewById<Button>(R.id.btn_greet).setOnClickListener {
            val inputText = findViewById<EditText>(R.id.editxt_name)
            val outputText = findViewById<TextView>(R.id.txt_message)

            outputText.text = String.format(getString(R.string.hello_message), inputText.text)
        }
    }
}
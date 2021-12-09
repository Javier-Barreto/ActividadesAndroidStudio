package com.itiudc.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val descriptiontext = findViewById<EditText>(R.id.description)
        val phonenumbertext = findViewById<TextView>(R.id.phonenumber)
        val goButton = findViewById<Button>(R.id.yes_button)
        goButton.setOnClickListener(){
            if(descriptiontext.text.isEmpty()) {
                Toast.makeText(this, "please type something...", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            phonenumbertext.text = descriptiontext.text
        }

    }
}
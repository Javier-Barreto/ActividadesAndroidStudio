package com.itiudc.actividad13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameinputbox = findViewById<EditText>(R.id.name_input)
        val ageinputbox = findViewById<EditText>(R.id.age_input)
        val answerbutton = findViewById<Button>(R.id.answer_button)

        answerbutton.setOnClickListener(){
        //----------------------------------//
        //VALIDAR SI LOS CAMPOS ESTAN VACIOS//
        //----------------------------------//
        if(ageinputbox.text.isEmpty()||nameinputbox.text.isEmpty())
        {
            Toast.makeText(this, "Please make sure to fill in all the fields!", Toast.LENGTH_SHORT).show()
        }
        else
        {
            //----------------------------------------------------------//
            //VALIDAR QUE LA EDAD NO SEA MAYOR O IGUAL A 100//
            //----------------------------------------------------------//
            if(Integer.parseInt(ageinputbox.text.toString())<0||Integer.parseInt(ageinputbox.text.toString())>=100)
            {
                Toast.makeText(this, "You can't put numbers above 99!", Toast.LENGTH_SHORT).show()
            }
            else
            {
                //-----------------------------//
                //VALIDAR SI ES UN DIGITO O DOS//
                //-----------------------------//
                var newAge1 = 0
                newAge1 = Integer.parseInt(ageinputbox.text.toString())
                var n1 = 0
                var n2 = 0

                if(ageinputbox.text.length==1)
                {
                    newAge1*=7

                    do
                    {
                        n1 = newAge1/10
                        n2 = newAge1%10
                        newAge1 = n1+n2
                    }while (newAge1>10)

                    Toast.makeText(this, "Welcome to the company, " + nameinputbox.text + ", your dunedain age is "
                            + newAge1, Toast.LENGTH_LONG).show()
                }
                else
                {
                    do{
                        n1 = newAge1 / 10
                        n2 = newAge1 % 10
                        newAge1 = n1 + n2
                    } while (newAge1 > 10)

                    Toast.makeText(this, "Welcome to the company, " + nameinputbox.text + ", your dunedain age is "
                                    + newAge1, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}
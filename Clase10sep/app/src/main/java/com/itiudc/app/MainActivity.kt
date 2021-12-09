package com.itiudc.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    companion object{
        private const val MY_VALUE: Int = 1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var name: String = "Javier"
        var age: Int = 33
        var yes: Boolean = true
        var teacherScore: Float = 2.71f
        var teacherScore2: Double = 2.71
        var draculaAge: Long = 45623632

        /*Log.i("Javier", "Kamo: $name")
        Log.i("Javier", "age: $age")
        Log.i("Javier", "yes: $yes")
        Log.i("Javier", "teacherScore: $teacherScore")
        Log.i("Javier", "teacherScore2: $teacherScore2")
        Log.i("Javier", "dracula age: $name")

        name = "Barreto"

        if(age > 60) {
            Log.i("Javier", "Eeres un adulto mayor")
        }else if(age >= 33) {
            Log.i("Javier", "eres un adulto")
        }else if(age <= 13) {
            Log.i("Javier", "eres un infante")
        }else{
            Log.i("Javier", "Eeres un dracula")
        }*/


        /*for(i in 1 ..10){
            Long.i("Javier","Item $i")
        }

        var i = 0
        while(i<=10){
            Log.i("Javier", "Item $i")
            i++
        }*/

        var names = arrayOf<String>("Pedro", "Juan","Julian")
        Log.i("Javier", "Pos1: ${names[1]}")

        /*for(i in names){
            Log.i("Javier", "${i}")
        }*/

        /*val result = sumar(1,6)
        Log.i("Javier", "Result $result")*/
    }

    /*fun sumar(FirstNumber: Int, secondNumber: Int) : Int{
        Log.i("Javier","FirstNumber ${FirstNumber} SeondNumber: ${secondNumber}")

        return FirstNumber + secondNumber
    }*/
}
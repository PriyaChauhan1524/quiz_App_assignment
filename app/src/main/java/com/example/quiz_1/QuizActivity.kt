package com.example.quiz_1

[11:39 pm, 23/11/2024] Divya: package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizActivity : AppCompatActivity() {
    lateinit var list: ArrayList<QuestionModel>
    var score:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        list=ArrayList<QuestionModel>()
        list.add(QuestionModel("What is the capital of France?", "Rome", "Paris", "Berlin", "Madrid", "Paris"))
        list.add(QuestionModel("Which planet is known as the 'Red Planet'?", "Venus", "Mars", "Jupiter", "Saturn", "Mars"))
        list.add(QuestionModel("Who wrote the play 'Romeo and Juliet'?", "Charles Dickens", "Mark Twain", "William Shakespeare", "Jane Austen", "William Shakespeare"))
        list.add(QuestionModel("What is the chemical symbol for water?", "CO2", "H2O", "NaCl", "O2", "H2O"))
        list.add(QuestionModel("Which country is famous for the Eiffel Tower?", "Italy", "France", "Germany", "Madrid", "Spain"))
        val question:TextView = findViewById(R.id.question)
        question.setText(list.get(0).question)
        findViewById<Button>(R.id.option1).setText(list.get(0).option1)
        findViewById<Button>(R.id.option2).setText(list.get(0).option2)
        findViewById<Button>(R.id.option3).setText(list.get(0).option3)
        findViewById<Button>(R.id.option4).setText(list.get(0).option4)
        findViewById<Button>(R.id.option1).setOnClickListener {
            nextData(findViewById<Button>(R.id.option1).text.toString())
        }
        findViewById<Button>(R.id.option2).setOnClickListener {
            nextData(findViewById<Button>(R.id.option2).text.toString())
        }
        findViewById<Button>(R.id.option3).setOnClickListener {
            nextData(findViewById<Button>(R.id.option3).text.toString())
        }
        findViewById<Button>(R.id.option4).setOnClickListener {
            nextData(findViewById<Button>(R.id.option4).text.toString())
        }
    }
    private var count:Int = 0
    fun nextData(i:String){
        if(count<list.size){
            if(list.get(count).ans.equals(i)){
                score++
            }
        }
        if(count>=list.size){
            val intent=Intent(this, ScoreActivity::class.java)
            intent.putExtra("SCORE", score)
            startActivity(intent)
            finish()
        }
        else{
            count++
            val question:TextView = findViewById(R.id.question)
            question.setText(list.get(0).question)
            findViewById<Button>(R.id.option1).setText(list.get(count).option1)
            findViewById<Button>(R.id.option2).setText(list.get(count).option2)
            findViewById<Button>(R.id.option3).setText(list.get(count).option3)
            findViewById<Button>(R.id.option4).setText(list.get(count).option4)
        }
    }
}

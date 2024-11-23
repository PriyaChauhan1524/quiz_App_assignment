package com.example.quiz_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.auth


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            Firebase.auth.createUserWithEmailAndPassword(findViewById<EditText>(R.id.email).text.toString(),findViewById<EditText>(R.id.password).text.toString()).addOnCompleteListener{
                if(it.isSuccessful){
                    Toast.makeText(this, "User Created", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "User not created", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
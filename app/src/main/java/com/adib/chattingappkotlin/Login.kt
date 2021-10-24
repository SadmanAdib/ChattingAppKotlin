package com.adib.chattingappkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Login : AppCompatActivity() {

    private lateinit var btn_signup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_signup=findViewById(R.id.btn_signup)


        btn_signup.setOnClickListener {

            val intent = Intent (this, SignUp::class.java)
            startActivity(intent)

        }


    }
}
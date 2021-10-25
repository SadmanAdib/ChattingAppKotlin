package com.adib.chattingappkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {

    private lateinit var btn_signup: Button
    private lateinit var edt_email: EditText
    private lateinit var edt_pasword: EditText
    private lateinit var btn_login: Button

    private lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_signup=findViewById(R.id.btn_signup)
        edt_email=findViewById(R.id.edt_email)
        edt_pasword=findViewById(R.id.edt_password)
        btn_login=findViewById(R.id.btn_login)

        auth = FirebaseAuth.getInstance()


        btn_signup.setOnClickListener {

            val intent = Intent (this, SignUp::class.java)
            startActivity(intent)

        }

        btn_login.setOnClickListener {
            val email = edt_email.text.toString()
            val password = edt_pasword.text.toString()

            if(email == "" && password =="")
            {
                Toast.makeText(baseContext, "Check Fields", Toast.LENGTH_SHORT).show()
            }
            else login(email, password)

        }


    }

    private fun login(email: String, password: String) {

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent (this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(baseContext, "User not found", Toast.LENGTH_SHORT).show()
                }
            }

    }
}
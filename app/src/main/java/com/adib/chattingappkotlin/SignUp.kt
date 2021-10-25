package com.adib.chattingappkotlin

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {

    private lateinit var btn_signup: Button
    private lateinit var edt_name: EditText
    private lateinit var edt_email: EditText
    private lateinit var edt_password: EditText

    private lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btn_signup = findViewById(R.id.btn_signup)
        edt_name = findViewById(R.id.edt_name)
        edt_email = findViewById(R.id.edt_email)
        edt_password = findViewById(R.id.edt_password)

        auth = FirebaseAuth.getInstance()

        btn_signup.setOnClickListener {
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }

        btn_signup.setOnClickListener {
            val email = edt_email.text.toString()
            val password = edt_password.text.toString()

            signUp(email, password)

        }

    }

    private fun signUp(email: String, password: String) {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent (this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(baseContext, "Sign Up Failed", Toast.LENGTH_SHORT).show()
                }
            }

    }
}
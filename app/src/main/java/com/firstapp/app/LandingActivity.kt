package com.firstapp.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LandingActivity : AppCompatActivity() {
    private lateinit var btnLogin: Button
    private lateinit var btnSignUp: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)


        btnLogin = findViewById(R.id.log_landing)
        btnSignUp = findViewById(R.id.sign_landing)

        btnLogin.setOnClickListener {
            startActivity(Intent(this@LandingActivity, LoginActivity::class.java))
        }

        btnSignUp.setOnClickListener {
            startActivity(Intent(this@LandingActivity, SignUpActivity::class.java))
        }
    }
}
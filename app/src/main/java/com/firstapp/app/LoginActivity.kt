package com.firstapp.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Find the button using the ID from the XML layout
        val signUpButton = findViewById<TextView>(R.id.createNewAccount)

        // Set OnClickListener for the button
        signUpButton.setOnClickListener {
            // Create an Intent to navigate to SignUpActivity
            val intent = Intent(this, Signup_Activity::class.java)

            // Start the SignUpActivity
            startActivity(intent)
        }
    }
}
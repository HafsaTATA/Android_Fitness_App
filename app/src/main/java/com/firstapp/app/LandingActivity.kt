package com.firstapp.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.firstapp.app.databinding.ActivityLandingBinding

class LandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        // Hafsa: just to test code:
        var binding =ActivityLandingBinding.inflate(layoutInflater) // Update with your actual layout file name
        setContentView(binding.root)

        // Set click listener for the Sign Up button
        binding.signLanding.setOnClickListener {
            // Start SignUpActivity when the Sign Up button is clicked
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        // Set click listener for the Log In button
        binding.logLanding.setOnClickListener {
            // Start LoginActivity when the Log In button is clicked
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}
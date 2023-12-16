package com.firstapp.app

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        // Load the original image
        val originalBitmap = BitmapFactory.decodeResource(resources, R.drawable.splash)

        // Resize the image
        val options = BitmapFactory.Options()
        options.inSampleSize = 2// Adjust this value to reduce the image size further

        // Create a new bitmap with the resized image
        val resizedBitmap = BitmapFactory.decodeResource(resources, R.drawable.splash, options)


        //pass to login landingInterface:
        val handler = Handler()
        handler.postDelayed({
            startActivity(Intent(this@SplashActivity, LandingActivity::class.java))
            finish()
        }, 2000)
    }
}
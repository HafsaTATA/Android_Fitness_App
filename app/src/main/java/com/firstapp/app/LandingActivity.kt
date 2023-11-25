package com.firstapp.app

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class LandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        // Load the original image
        val originalBitmap = BitmapFactory.decodeResource(resources, R.drawable.landing_button)

        // Resize the image
        val options = BitmapFactory.Options()
        options.inSampleSize = 2 // Adjust this value to reduce the image size further

        // Create a new bitmap with the resized image
        val resizedBitmap = BitmapFactory.decodeResource(resources, R.drawable.landing_button, options)

        // Assuming you have an ImageView with the id "imageView" in your layout
        val imageView: ImageView = findViewById(R.id.imageView)

        // Set the resized bitmap to the ImageView
        imageView.setImageBitmap(resizedBitmap)
    }
}
package com.firstapp.app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNavBar = findViewById<ChipNavigationBar>(R.id.BottomNavBar)
        bottomNavBar.setOnItemSelectedListener { id ->
            when (id) {
                R.id.nav_shopping -> {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.in/Gym-Equipment/s?k=Gym+Equipment"))
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}
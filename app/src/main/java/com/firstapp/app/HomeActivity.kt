package com.firstapp.app

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    lateinit var toggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val bottomNavView: BottomNavigationView = findViewById(R.id.bottomNavView)

        bottomNavView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_workouts -> {
                    val intent = Intent(this, BodyOptionsActivity::class.java)
                    startActivity(intent)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_map -> {
                    val intent = Intent(this, MapsActivity::class.java)
                    startActivity(intent)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_shopping ->{
                    val intent = Intent(this, ShoppingActivity::class.java)
                    startActivity(intent)
                    return@setOnNavigationItemSelectedListener true
                }

                else -> false
            }
        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    return@setNavigationItemSelectedListener true
                }

                R.id.shopping -> {
                    val intent = Intent(this, ShoppingActivity::class.java)
                    startActivity(intent)
                    return@setNavigationItemSelectedListener true
                }

                R.id.google_map -> {
                    val intent = Intent(this, MapsActivity::class.java)
                    startActivity(intent)
                    return@setNavigationItemSelectedListener true
                }

                else -> false
            }
        }

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}

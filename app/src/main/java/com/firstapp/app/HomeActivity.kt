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

class HomeActivity : AppCompatActivity() {

    private var drawerLayout: DrawerLayout? = null
    private var navigationView: NavigationView? = null

    private var drawerToggle: ActionBarDrawerToggle? = null

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (drawerToggle?.onOptionsItemSelected(item) == true) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)

        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open_drawer, R.string.close_drawer)
        drawerLayout?.addDrawerListener(drawerToggle!!)
        drawerToggle?.syncState()

        val bottomNavView: BottomNavigationView = findViewById(R.id.bottomNavView)

        bottomNavView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_workouts -> {
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_map -> {
                    val intent = Intent(this, MapsActivity::class.java)
                    startActivity(intent)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_shopping -> {
                    return@setOnNavigationItemSelectedListener true
                }

                else -> false
            }
        }

    }
    override fun onBackPressed() {
        if (drawerLayout?.isDrawerOpen(GravityCompat.START) == true) {
            drawerLayout?.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}

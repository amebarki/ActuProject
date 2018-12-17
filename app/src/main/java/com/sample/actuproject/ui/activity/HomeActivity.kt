package com.sample.actuproject.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sample.actuproject.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        findViewById<BottomNavigationView>(R.id.home_bottom_navigation)?.let {
                bottomNavigationView -> NavigationUI.setupWithNavController(bottomNavigationView,navHostFragment.navController)
        }
    }
}

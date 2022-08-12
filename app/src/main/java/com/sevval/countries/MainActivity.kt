package com.sevval.countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sevval.countries.repository.MainRepository
import com.sevval.countries.service.ApiService

class MainActivity : AppCompatActivity() {

    private lateinit var navController:NavController
    private lateinit var apiService: ApiService
    private lateinit var repository: MainRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
        navController = navHostFragment.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        apiService = ApiService()
        repository = MainRepository(apiService)

        setupWithNavController(bottomNavigationView, navController)
    }
}
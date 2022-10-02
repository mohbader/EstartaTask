package com.estarta.task.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.estarta.task.R
import com.estarta.task.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding

    private val navHostFragment by lazy {
        (supportFragmentManager.findFragmentById(R.id.activity_main_nav_host_fragment) as NavHostFragment)
    }
    private val navController by lazy { navHostFragment.navController }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)
        setupActionBarWithNavController(navController)
    }
}
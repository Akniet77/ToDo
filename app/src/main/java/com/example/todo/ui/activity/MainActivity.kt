package com.example.todo.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.todo.App
import com.example.todo.R
import com.example.todo.databinding.ActivityMainBinding
import java.util.IllegalFormatCodePointException

class MainActivity : AppCompatActivity() {
   private lateinit var controller: NavController
   private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        controller = navHostFragment.navController

        if (!App.pref.isBoardShow()) {
            controller.navigate(R.id.onBoardFragment)
        }
    }
}
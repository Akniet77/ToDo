package com.example.todo.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.todo.App
import com.example.todo.R
import com.example.todo.databinding.ActivityMainBinding
import com.example.todo.ui.fragment.contact.ContactFragment
import com.example.todo.ui.fragment.note.NoteFragment
import com.example.todo.ui.fragment.profile.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var controller: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        controller = navHostFragment.navController

        // Set up the bottom navigation view with the nav controller
        binding.navView.setupWithNavController(controller)

        // Hide the bottom navigation view when the user is on the onBoardFragment
        controller.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.onBoardFragment) {
                binding.navView.visibility = View.GONE
            } else {
                binding.navView.visibility = View.VISIBLE
            }
        }

        if (!App.pref.isBoardShow()) {
            controller.navigate(R.id.onBoardFragment)
        }

        binding.navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.noteFragment -> {
                    controller.navigate(R.id.noteFragment)
                    true
                }
                R.id.navigation_contact -> {
                    controller.navigate(R.id.contactFragment)
                    true
                }
                R.id.navigation_profile -> {
                    controller.navigate(R.id.profileFragment)
                    true
                }
                else -> false
            }
        }
    }
}
package com.example.todo

import android.app.Application
import android.content.SharedPreferences
import com.example.todo.ui.utils.Prefs

class App() : Application() {
    private lateinit var preferences: SharedPreferences

    companion object{
        lateinit var pref: Prefs
    }

    override fun onCreate() {
        super.onCreate()
        preferences = this.applicationContext.getSharedPreferences("settings", MODE_PRIVATE)
        pref = Prefs(preferences)
    }
}
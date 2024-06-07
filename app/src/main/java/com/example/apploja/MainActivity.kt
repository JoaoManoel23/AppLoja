package com.example.apploja

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.RecyclerView
import com.example.apploja.CodigoGeral.Adapter.ProductAdapter
import com.example.apploja.CodigoGeral.viewModels.MainViewModel
import com.example.apploja.Models.Product
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        val menuBotton = findViewById<BottomNavigationView>(R.id.menu_botton)
        val navController = Navigation.findNavController(this,R.id.nav_host_fragment)

        setSupportActionBar(toolbar)
        NavigationUI.setupWithNavController(menuBotton, navController)
        configureToolbar("Revenda de Carros", true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
package com.example.shopinventorymanagement

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        // Set up toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbarAddProd)
        setSupportActionBar(toolbar)

        // Enable the "up" button in the Action Bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    // Handle "up" button click event
    override fun onSupportNavigateUp(): Boolean {
        // Finish the current activity to go back to the previous activity
        onBackPressed()
        return true
    }
}
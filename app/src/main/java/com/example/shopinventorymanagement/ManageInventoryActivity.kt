package com.example.shopinventorymanagement

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
//import android.widget.Toolbar
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ManageInventoryActivity : AppCompatActivity() {

    private lateinit var btnAddProd: Button
    private lateinit var btnViewProd: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_inventory)

        // initializing
        init()

        // Set up toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbarManageInv)
        setSupportActionBar(toolbar)

        // Enable the "up" button in the Action Bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnAddProd.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AddProductActivity::class.java)
            startActivity(intent)
        })

        btnViewProd.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ViewProductActivity::class.java)
            startActivity(intent)
        })

    }

    fun init(){
        btnAddProd = findViewById(R.id.btnAddProd)
        btnViewProd = findViewById(R.id.btnViewProd)
    }

    // Handle "up" button click event
    override fun onSupportNavigateUp(): Boolean {
        // Finish the current activity to go back to the previous activity
        onBackPressed()
        return true
    }

}
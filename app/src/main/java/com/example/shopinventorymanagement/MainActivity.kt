package com.example.shopinventorymanagement

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btnManageInv: Button
    private lateinit var btnCheckOut: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // initializing view
        init()

        // manage inventory button functionality
        btnManageInv.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ManageInventoryActivity::class.java)
            startActivity(intent)
        })

        // Check out button functionality
        btnCheckOut.setOnClickListener(View.OnClickListener {

        })


    }

    fun init(){
        btnManageInv = findViewById(R.id.btnManageInv)
        btnCheckOut = findViewById(R.id.btnCheckOut)
    }

}
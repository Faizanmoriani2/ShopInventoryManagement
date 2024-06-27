package com.example.shopinventorymanagement

import ProductAdapter
import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ViewProductActivity : AppCompatActivity() {

    private lateinit var imgSearch: ImageView
    private lateinit var edtTxtSearch: EditText
    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter

    private val productList = mutableListOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_product)

        edtTxtSearch = findViewById(R.id.edtTxtSearch)
        imgSearch = findViewById(R.id.imgSearch)

        var searchText = edtTxtSearch.text.toString()

        // Search Functionality
        imgSearch.setOnClickListener(View.OnClickListener {

        })


        // Set up toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbarViewProd)
        setSupportActionBar(toolbar)

        // Enable the "up" button in the Action Bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Load some dummy data
        loadDummyData()

        // Initialize adapter and set it to RecyclerView
        productAdapter = ProductAdapter(productList)
        recyclerView.adapter = productAdapter
    }

    // Handle "up" button click event
    override fun onSupportNavigateUp(): Boolean {
        // Finish the current activity to go back to the previous activity
        onBackPressed()
        return true
    }
    private fun loadDummyData() {
        // Add dummy data to the productList
        productList.add(Product("#1", "Product A"))
        productList.add(Product("#2", "Product B"))
        productList.add(Product("#3", "Product C"))
    }

}
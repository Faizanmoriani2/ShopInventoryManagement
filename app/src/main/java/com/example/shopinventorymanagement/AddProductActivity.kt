package com.example.shopinventorymanagement

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.log

class AddProductActivity : AppCompatActivity() {

    private lateinit var btnSave: Button;
    private lateinit var btnDiscard: Button;
    private lateinit var btnScanBar: Button;
    private lateinit var edtTxtName: EditText;
    private lateinit var edtTxtBarcode: EditText;
    private lateinit var edtTxtPrice: EditText;
    private lateinit var edtTxtStock: EditText;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        // initialization
        init()

        // Set up toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbarAddProd)
        setSupportActionBar(toolbar)

        // Enable the "up" button in the Action Bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Button Save functionality
        btnSave.setOnClickListener(View.OnClickListener {
            val name = edtTxtName.text.toString().trim()
            val barcode = edtTxtBarcode.text.toString().trim()
            val stock = edtTxtStock.text.toString().trim()
            val price = edtTxtPrice.text.toString().trim()

            if(name.isNotEmpty() && barcode.isNotEmpty() && stock.isNotEmpty() && price.isNotEmpty()){
                Toast.makeText(this, "Added Product" + name + ": " + "\nprice: " + price, Toast.LENGTH_LONG)
                    .show()

            }
            else{
                Toast.makeText(this, "Kindly fill information", Toast.LENGTH_LONG)
                    .show()

            }
        })

        // Button Discard Functionality
        btnDiscard.setOnClickListener(View.OnClickListener {
            showConfirmationDialog()
        })

    }

    private fun showConfirmationDialog() {
        // Show a Confirmation Dialog
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Are you sure you want to discard?")
            .setCancelable(false)
            .setPositiveButton("Yes") { dialog, id ->
                // Handle the "Yes" button
                performDiscardAction()
            }
            .setNegativeButton("No") { dialog, id ->
                // Handle the "No" button
                dialog.dismiss()

            }
        val alert = builder.create()
        alert.show()
    }

    private fun performDiscardAction() {
        finish()
    }
    // Handle "up" button click event
    override fun onSupportNavigateUp(): Boolean {
        // Finish the current activity to go back to the previous activity
        onBackPressed()
        return true
    }

    fun init(){
        btnSave = findViewById(R.id.btnSave)
        btnDiscard = findViewById(R.id.btnDiscard)
        btnScanBar = findViewById(R.id.btnScanBarcode)
        edtTxtName = findViewById(R.id.edtTxtName)
        edtTxtPrice = findViewById(R.id.edtTxtPrice)
        edtTxtStock = findViewById(R.id.edtTextStock)
        edtTxtBarcode = findViewById(R.id.edtTxtBarCode)
    }

}
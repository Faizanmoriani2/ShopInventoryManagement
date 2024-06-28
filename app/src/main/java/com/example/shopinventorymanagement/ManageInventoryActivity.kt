package com.example.shopinventorymanagement

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.content.SharedPreferences
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
import com.example.shopinventorymanagement.utils.showToast
import com.example.shopinventorymanagement.contract.Request
import com.example.shopinventorymanagement.contract.Response
import com.example.shopinventorymanagement.network.IRequestContract
import com.example.shopinventorymanagement.network.NetworkClient
import com.example.shopinventorymanagement.utils.Constant
import com.example.shopinventorymanagement.utils.DataProvider
import retrofit2.Call
import retrofit2.Callback

class ManageInventoryActivity : AppCompatActivity(), Callback<Response> {

    private lateinit var btnAddProd: Button
    private lateinit var btnViewProd: Button
    private lateinit var progressDialog: ProgressDialog
    private val retrofitClient = NetworkClient.getNetworkClient()
    private val requestContract = retrofitClient.create(IRequestContract::class.java)

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

        // Progress bar code
        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("please wait...")
        progressDialog.setCancelable(true)

        btnAddProd.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AddProductActivity::class.java)
            startActivity(intent)
        })

        btnViewProd.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ViewProductActivity::class.java)
            startActivity(intent)
        })

    }

    override fun onStart() {
        super.onStart()
        progressDialog.show()
        val request = Request(
            action = Constant.GET_PRODUCTS
        )
        val callResponse = requestContract.makeApiCall(request)
        callResponse.enqueue(this)
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

    override fun onFailure(call: Call<Response>, t: Throwable) {
        if(progressDialog.isShowing)
            progressDialog.dismiss()
        showToast("Server is not responding. Please contact your system administrator")
    }

    override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
        if(progressDialog.isShowing)
            progressDialog.dismiss()
        if(response.body()!=null){
            val serverResponse = response.body()
            if(serverResponse!!.status){
                DataProvider.response = serverResponse
            }
            else{
                showToast(serverResponse.message)
            }
        }
        else{
            showToast("Server is not responding. Please contact your system administrator")
        }
    }

}
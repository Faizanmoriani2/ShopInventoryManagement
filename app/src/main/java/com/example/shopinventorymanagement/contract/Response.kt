package com.example.shopinventorymanagement.contract

import com.example.shopinventorymanagement.contract.Product

data class Response (
    var status:Boolean = false,
    var responseCode:Int = -1,
    var message:String = "",
    var barcode:String = "",
    var allProducts:MutableList<Product> = mutableListOf(),
)
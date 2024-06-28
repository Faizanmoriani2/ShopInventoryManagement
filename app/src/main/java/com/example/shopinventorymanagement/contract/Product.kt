package com.example.shopinventorymanagement.contract

import com.google.gson.annotations.SerializedName

data class Product (
    @SerializedName("product_id") var productId:String="",
//    @SerializedName("bloggerName") var bloggerName:String="",
    @SerializedName("name") var name:String="",
    @SerializedName("barcode") var barcode:String="",
    @SerializedName("stock") var stock:String="",
    @SerializedName("price") var price:String="",
)
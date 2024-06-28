package com.example.shopinventorymanagement.network

import com.example.shopinventorymanagement.contract.Request
import com.example.shopinventorymanagement.contract.Response
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface IRequestContract {
    @POST("service.php")
    fun makeApiCall(@Body request: Request):Call<Response>
}
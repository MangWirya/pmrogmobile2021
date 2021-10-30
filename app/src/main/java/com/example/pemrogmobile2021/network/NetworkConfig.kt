package com.example.pemrogmobile2021.network

import android.telecom.Call
import com.example.pemrogmobile2021.model.DataItem
import com.example.pemrogmobile2021.model.ResponseAddPetani
import com.example.pemrogmobile2021.model.ResponsePetani
import com.example.pemrogmobile2021.model.ResponseUserItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

class NetworkConfig {
    // set interceptor
    fun getInterceptor() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return okHttpClient
    }
    fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            //.baseUrl("https://jsonplaceholder.typicode.com/")
            .baseUrl("http://172.20.10.10/slim-tokobuah/public/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getService() = getRetrofit().create(Users::class.java)
}
interface Users {
    @GET("users")
    fun getUsers(): retrofit2.Call<List<ResponseUserItem>>

    @GET("petani/")
    fun getPetaniAll(): retrofit2.Call<ResponsePetani>

    @POST("petani/")
    fun addPetani(@Body req : DataItem): retrofit2.Call<ResponseAddPetani>

    @PUT("petani/{id}")
    fun updatePetani(@Path("id") id : Int, @Body req : DataItem): retrofit2.Call<ResponseAddPetani>

    @DELETE("petani/{id}")
    fun deletePetani(@Path("id") id : Int): retrofit2.Call<ResponseAddPetani>
}
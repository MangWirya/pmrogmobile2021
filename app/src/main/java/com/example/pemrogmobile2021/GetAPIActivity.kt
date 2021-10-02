package com.example.pemrogmobile2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pemrogmobile2021.adapter.UsersAdapter
import com.example.pemrogmobile2021.model.Petani
import com.example.pemrogmobile2021.model.ResponseUserItem
import com.example.pemrogmobile2021.network.NetworkConfig
import okhttp3.Callback
import okhttp3.Response

class GetAPIActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_apiactivity)
        var rvUserAPI = findViewById<RecyclerView>(R.id.rvUserAPI)
        var List = mutableListOf<ResponseUserItem>()
        NetworkConfig().getService()
            .getUsers()
            .enqueue(object : retrofit2.Callback <List<ResponseUserItem>> {
                override fun onFailure(call: retrofit2.Call<List<ResponseUserItem>>, t:Throwable) {
                    Toast.makeText(this@GetAPIActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }
                override fun onResponse(
                    call: retrofit2.Call<List<ResponseUserItem>>,
                    response: retrofit2.Response<List<ResponseUserItem>>
                ) {
                    rvUserAPI.apply{
                        layoutManager = LinearLayoutManager(this@GetAPIActivity)
                        adapter = UsersAdapter(response.body())
                    }
                }
            })
    }
}
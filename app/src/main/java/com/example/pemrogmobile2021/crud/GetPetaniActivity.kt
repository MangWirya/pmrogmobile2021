package com.example.pemrogmobile2021.crud

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pemrogmobile2021.LoginActivity
import com.example.pemrogmobile2021.R
import com.example.pemrogmobile2021.adapter.ResponsePetaniAdapter
import com.example.pemrogmobile2021.model.DataItem
import com.example.pemrogmobile2021.model.ResponsePetani
import com.example.pemrogmobile2021.network.NetworkConfig
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetPetaniActivity : AppCompatActivity() {
    lateinit var rvPetani: RecyclerView
    lateinit var fabAddPetani: FloatingActionButton
    val prefs_name = "session_login"
    lateinit var sharedPref : SharedPreferences
    lateinit var textEmail : TextView

   // override fun onCreate(savedInstanceState: Bundle?) {
     //   super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_get_petani)

    override fun onRestart() {
        super.onRestart()
        //setContentView(R.layout.activity_get_petani)

        rvPetani = findViewById(R.id.rvPetani)
        fabAddPetani = findViewById(R.id.fabAddPetani)
        textEmail = findViewById(R.id.textEmail)

        sharedPref = getSharedPreferences(prefs_name, Context.MODE_PRIVATE)

        val edEmail = sharedPref.getString("email", "")
        textEmail.text = edEmail


        NetworkConfig().getService()
            .getPetaniAll().enqueue(object : Callback<ResponsePetani?> {
                override fun onFailure(call: Call<ResponsePetani?>, t: Throwable) {
                    Toast.makeText(this@GetPetaniActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<ResponsePetani?>,
                    response: Response<ResponsePetani?>
                ) {
                    rvPetani.apply {
                        layoutManager = LinearLayoutManager(this@GetPetaniActivity)
                        adapter = ResponsePetaniAdapter(response.body()?.data as List<DataItem>?)

                    }
                }
            })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_logout, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.btnLogout -> {
                val editor : SharedPreferences.Editor = sharedPref.edit()
                editor.clear()
                editor.apply()
                finish()
                var intent = Intent(this@GetPetaniActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
           super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_petani)

        rvPetani = findViewById(R.id.rvPetani)
        fabAddPetani = findViewById(R.id.fabAddPetani)
        textEmail = findViewById(R.id.textEmail)

        sharedPref = getSharedPreferences(prefs_name, Context.MODE_PRIVATE)

        val edEmail = sharedPref.getString("email", "")
        textEmail.text = edEmail

        NetworkConfig().getService()
            .getPetaniAll().enqueue(object : Callback<ResponsePetani?> {
                override fun onFailure(call: Call<ResponsePetani?>, t: Throwable) {
                    Toast.makeText(this@GetPetaniActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<ResponsePetani?>,
                    response: Response<ResponsePetani?>
                ) {
                    rvPetani.apply {
                        layoutManager = LinearLayoutManager(this@GetPetaniActivity)
                        adapter = ResponsePetaniAdapter(response.body()?.data as List<DataItem>?)

                    }
                }
            })

        fabAddPetani.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@GetPetaniActivity, AddPetaniActivity::class.java)
            startActivity(intent)
        })
    }
}



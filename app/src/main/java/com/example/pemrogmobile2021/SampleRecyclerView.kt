package com.example.pemrogmobile2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pemrogmobile2021.adapter.PetaniAdapter
import com.example.pemrogmobile2021.model.Petani
import com.google.android.material.snackbar.Snackbar

class SampleRecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_recycler_view)

        var rvLatihan = findViewById<RecyclerView>(R.id.rvLatihan)
        var list = mutableListOf<Petani>()

        list.add(Petani("Yanto", "Nama : Kang yanto", "Total Laham : 1", "jum lahan : 2", "lahan tambah: 4"))
        list.add(Petani("Bangpen", "Nama : Kang Peny", "Total Laham : 2", "jum lahan : 1", "lahan tambah: 6"))
        list.add(Petani("Benny", "Nama : Kang Benny", "Total Laham : 3", "jum lahan : 3", "lahan tambah: 5"))

        rvLatihan.adapter = PetaniAdapter(list)
        rvLatihan.layoutManager = LinearLayoutManager(this)
    }
}

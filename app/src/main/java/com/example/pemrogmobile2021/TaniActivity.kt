package com.example.pemrogmobile2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import com.google.android.material.snackbar.Snackbar

class TaniActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tani)

        var listview = findViewById<ListView>(R.id.lisView)
        var list = mutableListOf<Model>()

        list.add(Model("Yanto", "Nama : Kang yanto", "Total Laham : 1", "jum lahan : 2", "lahan tambah: 4"))
        list.add(Model("Bangpen", "Nama : Kang Peny", "Total Laham : 2", "jum lahan : 1", "lahan tambah: 6"))
        list.add(Model("Benny", "Nama : Kang Benny", "Total Laham : 3", "jum lahan : 3", "lahan tambah: 5"))

        listview.adapter = MyAdapter(this, R.layout.row, list)

        listview.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view:
                View, position: Int, id: Long) {
                Snackbar.make(listview, "Anda memilih Yanto${position==0}", Snackbar.LENGTH_LONG).show()
                Snackbar.make(listview, "Anda memilih Yanto${position==1}", Snackbar.LENGTH_LONG).show()
                Snackbar.make(listview, "Anda memilih Yanto${position==2}", Snackbar.LENGTH_LONG).show()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}
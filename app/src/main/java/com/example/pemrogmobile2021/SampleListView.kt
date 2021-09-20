package com.example.pemrogmobile2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import com.google.android.material.snackbar.Snackbar

class SampleListView : AppCompatActivity() {
    var items1 = arrayOf(
       "lorem ", "ipsum", "dolor", "sit", "amet",
        "consectetuer", "adipiscing", "elit", "morbi", "vel",
        "ligula", "vitae", "arcu", "aliquet", "mollis",
        "etiam", "vel", "erat", "placerat", "ante",
        "porttitor", "sodales", "pellentesque", "augue", "purus"
    )
    lateinit var spSampleList : Spinner
    lateinit var lvSample : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_list_view)

        lvSample = findViewById(R.id.lvSample)
        lvSample.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items1 )
        lvSample.setOnItemClickListener { parent, view, i, l ->
            Snackbar.make(view,"Anda memilih: ${items1[i]}",
                Snackbar.LENGTH_LONG).show()
        }
        spSampleList = findViewById(R.id.spSampleListView)
        spSampleList.adapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_item, items1)
        spSampleList.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view:
            View, position: Int, id: Long) {
                Snackbar.make(lvSample, "Anda memilih${items1[position]}", Snackbar.LENGTH_LONG).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

        registerForContextMenu(lvSample)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?,
                                     menuInfo: ContextMenu.ContextMenuInfo?){
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_sample_list_view, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        var info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        when(item.itemId){
            R.id.menu_add -> {
                Snackbar.make(lvSample,"Anda memilih: Add Item ke-${info.id}", Snackbar.LENGTH_LONG).show()
            }
            R.id.menu_edit -> {
                Snackbar.make(lvSample,"Anda memilih: Edit Item ke-${info.id}", Snackbar.LENGTH_LONG).show()
            }
            R.id.menu_delete -> {
                Snackbar.make(lvSample,"Anda memilih: Delete Item ke-${info.id}", Snackbar.LENGTH_LONG).show()
            }
        }
        return super.onContextItemSelected(item)
    }

}
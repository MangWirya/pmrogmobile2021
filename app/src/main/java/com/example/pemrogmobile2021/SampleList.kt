package com.example.pemrogmobile2021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class SampleList : AppCompatActivity() {
    lateinit var btnShowList : Button
    lateinit var btnSampleRV : Button
    lateinit var btnCardView : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_list)

        btnShowList = findViewById(R.id.btnShowList)
        btnSampleRV = findViewById(R.id.btnSampleRV)
        btnCardView = findViewById(R.id.btnCardview)


        btnShowList.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@SampleList, SampleListView::class.java)
            startActivity(intent)
        })

        btnSampleRV.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@SampleList, SampleRecyclerView::class.java)
            startActivity(intent)
        })

        btnCardView.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@SampleList, SampleCardView::class.java)
            startActivity(intent)
        })

    }
}
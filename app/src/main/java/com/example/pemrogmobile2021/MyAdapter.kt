package com.example.pemrogmobile2021

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MyAdapter (var mCtx:Context, var resoursce:Int, var items:List<Model>):ArrayAdapter<Model>(mCtx, resoursce, items){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(mCtx)
        val view:View = layoutInflater.inflate(resoursce, null)

        val txtMain:TextView = view.findViewById(R.id.txtMain)
        val txtSub1:TextView = view.findViewById(R.id.txtSub1)
        val txtSub2:TextView = view.findViewById(R.id.txtSub2)
        val txtSub3:TextView = view.findViewById(R.id.txtSub3)
        val txtSub4:TextView = view.findViewById(R.id.txtSub4)

        var mItem:Model = items[position]
        txtMain.text = mItem.tittle
        txtSub1.text = mItem.desc1
        txtSub2.text = mItem.desc2
        txtSub3.text = mItem.desc3
        txtSub4.text = mItem.desc4

        return view
    }
}
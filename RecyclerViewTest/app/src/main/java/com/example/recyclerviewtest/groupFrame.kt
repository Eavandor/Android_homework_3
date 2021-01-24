package com.example.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class groupFrame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_group_frame)
var conten=intent.getStringExtra("gpn")
 var idimg=intent.getIntExtra("imgid",0)
        var f: ImageView=findViewById<ImageView>(idimg)
        f.setImageResource(idimg)
        var t: TextView=findViewById<TextView>(R.id.f2)
        t.text=conten

    }
}
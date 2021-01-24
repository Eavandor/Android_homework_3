package com.example.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main2.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var n=intent.getStringExtra("gpn")
        var n2=intent.getIntExtra("imgid",0)
        var text1:EditText=findViewById(R.id.text1)
        text1.setText(n.replace("\\n","\n"))
        final_image.setImageResource(n2)
        AllActivities.addActivity(this)
    }
}
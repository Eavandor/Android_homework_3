package com.example.recyclerviewtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class AddActivity : AppCompatActivity(){
    companion object{
        val fruitList = ArrayList<Fruit>()
        val apple = R.drawable.apple_pic
        val banana = R.drawable.banana_pic
        val orange = R.drawable.orange_pic
        val gf=R.drawable.gf
        var count: Int=0

    }
    fun initFruits(n :String,obj :Int) {
        repeat(1) {
            AddActivity.fruitList.add(0,Fruit(n, obj))
        }
     }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var submit: Button=findViewById(R.id.submit)
        submit.setOnClickListener() {
            val etg: EditText = findViewById(R.id.ETgroup)
            val etn: EditText = findViewById(R.id.ETcreaterName)
            val group = etg.text.toString();
            val name = etn.text.toString()
            AllActivities.addActivity(this)
            if(fruitList.isEmpty()==false&&"群名:"+group +"\n  (创建人:"+ name+")"== fruitList.get(0).name.replace("\\n","\n",false)){
                Toast.makeText(this,"相邻Item不可以相同哦！", Toast.LENGTH_LONG).show();//相邻Item不能一样（附加题）

                       AlertDialog.Builder(this).apply {
                           setTitle("相邻Item不可以相同哦！")
                           setMessage("这个群名和创建人，和上一个雷同哦！请换一个~")
                           setCancelable(false)
                           setPositiveButton("好") { dialog, which ->

                           }
                           setNegativeButton("滚") { dialog,
                                                    which ->

                           }
                           show()
                       }

            }else {
                Toast.makeText(this, "成功创建群聊:" + group + ",创建人:" + name, Toast.LENGTH_SHORT).show();
                if (count % 4 == 0) {
                    initFruits("群名:" + group + "\n  (创建人:" + name + ")", apple)
                } else if (count % 4 == 1) {
                    initFruits("群名:" + group + "\n  (创建人:" + name + ")", banana)
                } else if (count % 4 == 2) {
                    initFruits("群名:" + group + "\n  (创建人:" + name + ")", orange)
                } else {
                    initFruits("群名:" + group + "\n  (创建人:" + name + ")", gf)
                }
                count++
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        }
    }
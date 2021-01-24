package com.example.recyclerviewtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AllActivities.addActivity(this)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = FruitAdapter(AddActivity.fruitList, this)
        recyclerView.adapter = adapter
    var add_group: Button=findViewById(R.id.addgroup)
    var clear_group: Button=findViewById(R.id.clearlist)
    var exit_button: Button=findViewById(R.id.exitapp)
    add_group.setOnClickListener {
        var intent = Intent(this, AddActivity::class.java)

        this.startActivity(intent)
    }
    clear_group.setOnClickListener {
        AddActivity.fruitList.clear()
        var intent4 = Intent(this, MainActivity::class.java)

        this.startActivity(intent4)
    }
    exit_button.setOnClickListener {

        AlertDialog.Builder(this).apply {
            setTitle("给我100分好不好QAQ")
            setMessage("（看在我做的这么辛苦的份上555555）")
            setCancelable(false)
            setPositiveButton("好") { dialog, which -> AllActivities.finishAll()

            }
            setNegativeButton("100分哪里够？1000！") { dialog,
                                                 which -> AllActivities.finishAll()

            }
            show()
        }
    }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item != null) {
            when(item.itemId){
                R.id.item1 -> {
                    var intent = Intent(this, AddActivity::class.java)

                    this.startActivity(intent)
                }
                R.id.item2 -> {
                    AddActivity.fruitList.clear()
                    var intent4 = Intent(this, MainActivity::class.java)

                    this.startActivity(intent4)
                }
                R.id.item3 -> {
                    AlertDialog.Builder(this).apply {
                        setTitle("给我100分好不好QAQ")
                        setMessage("（看在我做的这么辛苦的份上555555）")
                        setCancelable(false)
                        setPositiveButton("好") { dialog, which ->AllActivities.finishAll()

                        }
                        setNegativeButton("100分哪里够？1000！") { dialog,
                                                             which ->AllActivities.finishAll()

                        }
                        show()
                    }

                }

            }
        }



        return true
    }
}

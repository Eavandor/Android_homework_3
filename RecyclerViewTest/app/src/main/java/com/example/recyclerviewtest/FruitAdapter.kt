package com.example.recyclerviewtest
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.widget.Toast
import kotlin.collections.ArrayList

class FruitAdapter(val fruitList: ArrayList<Fruit>,val con :Context) : RecyclerView.Adapter<FruitAdapter.ViewHolder>(){
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
        val fruitName: TextView = view.findViewById(R.id.fruitName)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = fruitList[position]
            val img=fruit.imageId
            val fname=fruit.name
            Toast.makeText(parent.context, "you clicked view ${fruit.name}", Toast.LENGTH_LONG).show()
            var intent = Intent(con, DetailActivity::class.java)
            intent.putExtra("gpn",fname)
            intent.putExtra("imgid",img)
              con.startActivity(intent)
        }
        viewHolder.fruitImage.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = fruitList[position]
            val img=fruit.imageId
            val fname=fruit.name
            Toast.makeText(parent.context, "you clicked image ${fruit.name}", Toast.LENGTH_LONG).show()
            var intent = Intent(con, DetailActivity::class.java)
            intent.putExtra("gpn",fname)
            intent.putExtra("imgid",img)
            con.startActivity(intent)
        }
        return viewHolder
    }
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.fruitImage.setImageResource(fruit.imageId)
        holder.fruitName.text = fruit.name
    }
    override fun getItemCount() = fruitList.size
}
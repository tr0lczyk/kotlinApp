package com.williamhill.maciekappkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.williamhill.maciekappkotlin.model.Example

class KiedyAdapter(private val list: MutableList<Example?>, private val context: Context) :
    RecyclerView.Adapter<KiedyAdapter.KiedyViewHolder>() {

    class KiedyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageView)
        val text1: TextView = itemView.findViewById(R.id.text1)
        val text2: TextView = itemView.findViewById(R.id.text2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KiedyViewHolder {
        return KiedyViewHolder(
            LayoutInflater.from(context).inflate(R.layout.example_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: KiedyViewHolder, position: Int) {
        val currentExample = list[position]
        Picasso.get().load("https://i.imgur.com/tGbaZCY.jpg").into(holder.image)
        holder.text1.text = currentExample?.name
        holder.text2.text = currentExample?.id.toString()
    }
}
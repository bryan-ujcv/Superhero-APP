package com.app.superheroapp2

import android.content.Intent
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cont.view.*

class SupAdapter (val image: List<String>): RecyclerView.Adapter<SupAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = image[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.activity_main, parent, false))
    }

    override fun getItemCount(): Int{
        return image.size
    }

    fun onclick_menutats(){
        pwrStats.setOnClickListener(){
            val powerstatsmenu: Intent= Intent(applicationcontext,SupResponse::class.java)
            startActivity(powerstatsmenu)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(image: String) {
            itemView.ivDog.fromUrl(image)
        }
    }




}

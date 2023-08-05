package com.kotlinrecy.kotlinrecyc

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val activity: Activity,val  vaccineList:ArrayList<Myvaccine>) :RecyclerView.Adapter<MyAdapter.MyviewHolder>() {




    inner  class MyviewHolder( itemview: View) : RecyclerView.ViewHolder(itemview){
 var namevie:TextView
 var imageView: ImageView


init {
    namevie=itemview.findViewById(R.id.vaccinename)
    imageView=itemview.findViewById(R.id.vacccineimage)
    itemview.setOnClickListener {
        Toast.makeText(activity,"You choose ${vaccineList[adapterPosition].name}",Toast.LENGTH_SHORT).show()
    }
}





    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
       val v=LayoutInflater.from(parent.context).inflate(R.layout.recyclerview,parent,false)
        return MyviewHolder(v)
    }

    override fun getItemCount(): Int {
        return vaccineList.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        holder.namevie.text=vaccineList[position].name
        holder.imageView.setImageResource(vaccineList[position].id)

    }
}
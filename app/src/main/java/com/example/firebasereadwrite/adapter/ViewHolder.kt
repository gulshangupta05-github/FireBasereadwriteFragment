package com.example.firebasereadwrite.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasereadwrite.R
import kotlinx.android.synthetic.main.showdata.view.*

class ViewHolder (itemView:View):RecyclerView.ViewHolder(itemView){
    val tvName=itemView.findViewById<TextView>(R.id.tvName)
}
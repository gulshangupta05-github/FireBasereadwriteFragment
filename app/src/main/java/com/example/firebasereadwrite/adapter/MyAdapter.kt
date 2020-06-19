package com.example.firebasereadwrite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasereadwrite.R
import com.example.firebasereadwrite.userInfo.UserInfo

abstract class MyAdapter(loadData: ArrayList<UserInfo>, private val mDatas:ArrayList<UserInfo>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.showdata, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return  mDatas.size
    }

//    override fun onBindViewHolder(holder:ViewHolder,position:Int) {
//    holder.tvname.text=mDatas[position].name
//    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvname.text=mDatas[position].name
    }

}
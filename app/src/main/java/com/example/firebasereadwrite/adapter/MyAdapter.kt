package com.example.firebasereadwrite.adapter


import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.createDeviceProtectedStorageContext
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasereadwrite.AllDataRecyclerView
import com.example.firebasereadwrite.LoadData
import com.example.firebasereadwrite.R
import com.example.firebasereadwrite.userInfo.UserInfo

class MyAdapter(loadData: LoadData, val mDatas: ArrayList<UserInfo>, val context: Context) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false))


    }

    override fun getItemCount(): Int {
        return mDatas.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = mDatas[position].name
        holder.tvemail.text = mDatas[position].email
        holder.tvaddress.text = mDatas[position].address
                holder.nextactive.setOnClickListener(){
//                    context.startActivity(Intent,AllDataRecyclerView::class.java)
            context.startActivity(
                Intent(context,AllDataRecyclerView::class.java).putExtra("key",mDatas[position])
                    )
                }
//        holder.tvmobile.text = mDatas[position].mobile
//        holder.tvfathername.text = mDatas[position].father
//        holder.tvmother.text = mDatas[position].mother
//        holder.tvcity.text = mDatas[position].city
//        holder.tvcountry.text = mDatas[position].country
//        holder.tvpostal.text = mDatas[position].postal
//        holder.tvcompanyname.text = mDatas[position].company

    }


}



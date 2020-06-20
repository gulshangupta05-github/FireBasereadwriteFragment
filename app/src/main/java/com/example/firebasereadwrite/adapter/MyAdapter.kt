package com.example.firebasereadwrite.adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasereadwrite.AllDataRecyclerViewActivity
import com.example.firebasereadwrite.LoadDataActivity
import com.example.firebasereadwrite.R
import com.example.firebasereadwrite.userInfo.UserInfo

class MyAdapter(
    loadDataActivity: LoadDataActivity,
    val mDatas: ArrayList<UserInfo>,
    val context: Context
) :
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
        holder.nextactive.setOnClickListener() {
//                    context.startActivity(Intent,AllDataRecyclerView::class.java)
            context.startActivity(
                Intent(context, AllDataRecyclerViewActivity::class.java)
                    .putExtra("document_id", mDatas[position].document_id)
                    .putExtra("name", mDatas[position].name)
                    .putExtra("email", mDatas[position].email)
                    .putExtra("address", mDatas[position].address)
                    .putExtra("mobile", mDatas[position].mobile)
                    .putExtra("father", mDatas[position].father)
                    .putExtra("mother", mDatas[position].mother)
                    .putExtra("city", mDatas[position].city)
                    .putExtra("country", mDatas[position].country)
                    .putExtra("postal", mDatas[position].postal)
                    .putExtra("company", mDatas[position].company)
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



package com.example.firebasereadwrite.adapter

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasereadwrite.R


class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvName = itemView.findViewById<TextView>(R.id.tvName)
    val tvemail = itemView.findViewById<TextView>(R.id.tvEmail)
    val tvaddress = itemView.findViewById<TextView>(R.id.tvAddress)
    val nextactive=itemView.findViewById<LinearLayout>(R.id.nextativity)
    val tvmobile = itemView.findViewById<TextView>(R.id.tvMobile)
    val tvfathername = itemView.findViewById<TextView>(R.id.tvFather)
    val tvmother = itemView.findViewById<TextView>(R.id.tvMother)
    val tvcity = itemView.findViewById<TextView>(R.id.tvCity)
    val tvcountry = itemView.findViewById<TextView>(R.id.tvCountry)
    val tvpostal = itemView.findViewById<TextView>(R.id.tvPostal)
    val tvcompanyname = itemView.findViewById<TextView>(R.id.tvCompanyname)



}
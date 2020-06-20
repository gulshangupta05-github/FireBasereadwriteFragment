package com.example.firebasereadwrite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebasereadwrite.alldatarecyclerview.AllDataRecyclerviewFragment

class AllDataRecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val document_id=intent.getStringExtra("document_id")
        val fname=intent.getStringExtra("name")
        val femail=intent.getStringExtra("email")
        val faddress=intent.getStringExtra("address")
        val fmobile=intent.getStringExtra("mobile")
        val ffather=intent.getStringExtra("father")
        val fmother=intent.getStringExtra("mother")
        val fcity=intent.getStringExtra("city")
        val fcountry=intent.getStringExtra("country")
        val fpostal=intent.getStringExtra("postal")
        val fcompany=intent.getStringExtra("company")
        //val fname = intent.getSerializableExtra("name") as UserInfo//Yha hum getExtraString Metod se bhi get kar skate hai
//        val femail=intent.getSerializableExtra("email")as UserInfo//Yha hum getExtraString Metod se bhi get kar skate hai
//        val faddress=intent.getSerializableExtra("address")as UserInfo
//        val fmobile=intent.getSerializableExtra("mobile")as UserInfo
//        val ffather=intent.getSerializableExtra("father") as UserInfo
//        val fmother=intent.getSerializableExtra("mother")as UserInfo
//        val fcity =intent.getSerializableExtra("city")as UserInfo
//        val fcountry=intent.getSerializableExtra("country") as UserInfo
//        val fpostal=intent.getSerializableExtra("postal")as UserInfo
//        val fcompany=intent.getSerializableExtra("company")as UserInfo



       // Log.d("AllDataRecyclerView", fname.name)///////////

        setContentView(R.layout.activity_all_data_recycler_view)
        supportFragmentManager.beginTransaction().replace(
            R.id.container, AllDataRecyclerviewFragment(document_id,fname,femail, faddress,fmobile,ffather,fmother,fcity,fcountry,fpostal,fcompany)
        ).commit()
    }
}
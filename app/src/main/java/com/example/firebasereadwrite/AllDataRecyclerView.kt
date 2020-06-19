package com.example.firebasereadwrite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.firebasereadwrite.alldatarecyclerview.AllDataRecyclerviewFragment
import com.example.firebasereadwrite.loaddata.LoadDataFragment
import com.example.firebasereadwrite.userInfo.UserInfo

class AllDataRecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val key = intent.getSerializableExtra("key") as UserInfo/////////////////
        Log.d("AllDataRecyclerView", key.company)///////////

        setContentView(R.layout.activity_all_data_recycler_view)
        supportFragmentManager.beginTransaction().replace(
            R.id.container, AllDataRecyclerviewFragment.newInstance()
        ).commit()
    }
}
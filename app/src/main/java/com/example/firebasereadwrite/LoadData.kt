package com.example.firebasereadwrite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebasereadwrite.loaddata.LoadDataFragment
import com.example.firebasereadwrite.savedata.SaveDataFragment

class LoadData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_data)
        supportFragmentManager.beginTransaction().replace(
            R.id.container, LoadDataFragment.newInstance()
        ).commit()
    }
}

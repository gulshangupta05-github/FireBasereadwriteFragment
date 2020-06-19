package com.example.firebasereadwrite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebasereadwrite.savedata.SaveDataFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(
            R.id.container,SaveDataFragment.newInstance()
        ).commit()
    }
}

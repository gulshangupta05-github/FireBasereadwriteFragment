package com.example.firebasereadwrite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebasereadwrite.profileedit.ProfileEditFragment

class ProfileEditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_edit)
        val document_id = intent.getStringExtra("document_id")
        val ename = intent.getStringExtra("name")
        val eemail = intent.getStringExtra("email")
        val eaddress = intent.getStringExtra("address")
        val emobile = intent.getStringExtra("mobile")
        val efather = intent.getStringExtra("father")
        val emother = intent.getStringExtra("mother")
        val ecity = intent.getStringExtra("city")
        val ecountry = intent.getStringExtra("country")
        val epostal = intent.getStringExtra("postal")
        val ecompany = intent.getStringExtra("company")
        supportFragmentManager.beginTransaction().replace(
            R.id.container,
            ProfileEditFragment(
                document_id,
                ename,
                eemail,
                eaddress,
                emobile,
                efather,
                emother,
                ecity,
                ecountry,
                epostal,
                ecompany
            )
        ).commit()
    }
}
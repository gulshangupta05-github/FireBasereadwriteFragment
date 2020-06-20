package com.example.firebasereadwrite.savedata

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.firebasereadwrite.LoadDataActivity

import com.example.firebasereadwrite.R
import com.example.firebasereadwrite.userInfo.UserInfo
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.save_data_fragment.*

class SaveDataFragment : Fragment() {

    companion object {
        fun newInstance() = SaveDataFragment()
    }

    val TAG = "MainActivityTag"
    lateinit var firebase: FirebaseFirestore
    private lateinit var viewModel: SaveDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.save_data_fragment, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SaveDataViewModel::class.java)
        // TODO: Use the ViewModel
        firebasesend.setOnClickListener {
            firebase = FirebaseFirestore.getInstance()
            val sName = et_name.text.toString().trim()
            val sAddress = et_address.text.toString().trim()
            val sEmail = et_email.text.toString().trim()
            val sMobile = et_mobile.text.toString().trim()
            val sFather = et_fathername.text.toString().trim()
            val sMother = et_mothername.text.toString().trim()
            val sCity = et_city.text.toString().trim()
            val sCountry = et_country.text.toString().trim()
            val sPostal = et_postalcode.text.toString().trim()
            val sCompany = et_companyname.text.toString().trim()

            if (sName == "" || sAddress == "" || sEmail == "" || sMobile == "" || sFather == ""
                || sMother == "" || sCity == "" || sCountry == "" || sPostal == "" || sCompany == ""
            ) {
                Toast.makeText(context, "Empty", Toast.LENGTH_SHORT).show()
            } else {
                val data =
                    UserInfo(
                        name = sName,
                        email = sEmail,
                        address = sAddress,
                        mobile = sMobile,
                        father = sFather,
                        mother = sMother,
                        city = sCity,
                        country = sCountry,
                        postal = sPostal,
                        company = sCompany
                    )
                firebase.collection("users").document().set(data)
                    .addOnSuccessListener {
                        Toast.makeText(context, "data saved", Toast.LENGTH_SHORT).show()
                        Log.d(TAG, "databased")
                    }.addOnFailureListener {
                        Toast.makeText(context, "Connection Error", Toast.LENGTH_SHORT).show()
                        Log.d(TAG, "onCreate: ")
                    }
            }
        }
        loaddata.setOnClickListener() {
            val intent = Intent(context, LoadDataActivity::class.java)
            startActivity(intent)
            Log.d(TAG, "pass")
        }
    }

}

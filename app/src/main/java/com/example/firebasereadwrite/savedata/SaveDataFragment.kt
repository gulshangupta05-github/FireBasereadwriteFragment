package com.example.firebasereadwrite.savedata

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.firebasereadwrite.LoadData

import com.example.firebasereadwrite.R
import com.example.firebasereadwrite.userInfo.UserInfo
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.save_data_fragment.*

class SaveDataFragment : Fragment() {

    companion object {
        fun newInstance() = SaveDataFragment()
    }
             lateinit var firebase:FirebaseFirestore
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

        firebase=FirebaseFirestore.getInstance()
        val sName = et_name.text.toString().trim()
        val sAddress = et_address.text.toString().trim()
        val sEmail = et_email.text.toString().trim()
        val sMobile = et_mobile.text.toString().trim()

        if (sName == "" || sAddress == "" || sEmail == "" || sMobile == "") {
            Toast.makeText(context, "Empty", Toast.LENGTH_SHORT).show()
        } else {
            val  data=UserInfo(name= sName,email = sEmail,address = sAddress,mobile = sMobile)
            firebase.collection("users").document().set(data)
                .addOnSuccessListener {
                    Toast.makeText(context,"datasaved",Toast.LENGTH_SHORT).show()
                }
        }
        senddata.setOnClickListener(){
            val intent=Intent(context,LoadData::class.java)
            startActivity(intent)
        }
    }

}

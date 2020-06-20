package com.example.firebasereadwrite.profileedit

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.firebasereadwrite.R
import com.example.firebasereadwrite.userInfo.UserInfo
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.profile_edit_fragment.*

class ProfileEditFragment(
    val document_id:String,
    val ename: String?,
    val eemail: String?,
    val eaddress: String?,
    val emobile: String?,
    val efather: String?,
    val emother: String?,
    val ecity: String?,
    val ecountry: String?,
    val epostal: String?,
    val ecompany: String?

) : Fragment() {

    lateinit var firestore: FirebaseFirestore
    private lateinit var viewModel: ProfileEditViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_edit_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProfileEditViewModel::class.java)


        et_name.setText(ename)
        et_email.setText(eemail)
        et_address.setText(eaddress)
        et_mobile.setText(emobile)
        et_fathername.setText(efather)
        et_mothername.setText(emother)
        et_city.setText(ecity)
        et_country.setText(ecountry)
        et_postalcode.setText(epostal)
        et_companyname.setText(ecompany)


        resend.setOnClickListener() {
            firestore = FirebaseFirestore.getInstance()

            val Editname = et_name.text.toString().trim()
            val Editemail = et_email.text.toString().trim()
            val Editaddress = et_address.text.toString().trim()
            val Editmobile = et_mobile.text.toString().trim()
            val Editfather = et_fathername.text.toString().trim()
            val Editmother = et_mothername.text.toString().trim()
            val Editcity = et_city.text.toString().trim()
            val Editcountry = et_country.text.toString().trim()
            val Editpostal = et_postalcode.text.toString().trim()
            val Editcompany = et_companyname.text.toString().trim()
            if (ename == "" || eemail == "" || eaddress == "" || emobile == "" || efather == "" || emother == "" || ecity == "" || ecountry == "" || epostal == "" || ecompany == "") {
                Toast.makeText(context, "Empty", Toast.LENGTH_SHORT).show()
            } else {
                val data =
                    UserInfo(
                        name = Editname,
                        email = Editemail,
                        address = Editaddress,
                        mobile = Editmobile,
                        father = Editfather,
                        mother = Editmother,
                        city = Editcity,
                        country = Editcountry,
                        postal = Editpostal,
                        company = Editcompany
                    )
                firestore.collection("users").document(document_id).set(data)
                    .addOnSuccessListener {
                        Toast.makeText(context, "data Resaved", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener() {
                        Toast.makeText(context, "data not saved", Toast.LENGTH_SHORT).show()
                    }
            }
        }


    }

}
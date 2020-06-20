package com.example.firebasereadwrite.alldatarecyclerview

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firebasereadwrite.ProfileEditActivity
import com.example.firebasereadwrite.R
import kotlinx.android.synthetic.main.all_data_recyclerview_fragment.*
import kotlinx.android.synthetic.main.save_data_fragment.*

class AllDataRecyclerviewFragment(
    val document_id: String?,
    val fname: String?,
   val  femail: String?,
    val faddress: String?,
    val fmobile: String?,
    val   ffather: String?,
    val  fmother: String?,
    val fcity: String?,
    val  fcountry: String?,
    val fpostal: String?,
    val fcompany: String?
) : Fragment()  {


    private lateinit var viewModel: AllDataRecyclerviewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.all_data_recyclerview_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AllDataRecyclerviewViewModel::class.java)

        tvName.text=fname
        tvEmail.text=femail
        tvAddress.text=faddress
        tvMobile.text=fmobile
        tvFather.text=ffather
        tvMother.text=fmother
        tvCity.text=fcity
        tvCountry.text=fcountry
        tvPostal.text=fpostal
        tvCompanyname.text=fcompany
//        tvName.text=fname.toString() ///yha data set hua hai

//        val key=context .

        edit_profile.setOnClickListener(){
            val intent=Intent(requireContext(),ProfileEditActivity::class.java)
                .putExtra("document_id",document_id)
                .putExtra("name",fname)
                .putExtra("email",femail)
                .putExtra("address",faddress)
                .putExtra("mobile",fmobile)
                .putExtra("father",ffather)
                .putExtra("mother",fmother)
                .putExtra("city",fcity)
                .putExtra("country",fcountry)
                .putExtra("postal",fpostal)
                .putExtra("company",fcompany)
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            //activity?.finish()
        }

    }


}
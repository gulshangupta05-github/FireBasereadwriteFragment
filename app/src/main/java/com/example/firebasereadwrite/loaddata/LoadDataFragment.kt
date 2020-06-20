package com.example.firebasereadwrite.loaddata


import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.firebasereadwrite.LoadDataActivity

import com.example.firebasereadwrite.R
import com.example.firebasereadwrite.adapter.MyAdapter
import com.example.firebasereadwrite.userInfo.UserInfo
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import kotlinx.android.synthetic.main.load_data_fragment.*

//@Suppress("UNREACHABLE_CODE")
class LoadDataFragment : Fragment() {
    private lateinit var firestore: FirebaseFirestore
    private lateinit var viewModel: LoadDataViewModel
    private var mDatas = ArrayList<UserInfo>()
    val TAG = "LoadDataActivity"

    companion object {
        fun newInstance() = LoadDataFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.load_data_fragment, container, false)


    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoadDataViewModel::class.java)
        firestore = FirebaseFirestore.getInstance()

        firestore.collection("users").get()
            .addOnSuccessListener {
                it.forEach {
                    val document_id = it.id
                    val data = it.toObject(UserInfo::class.java)
                    mDatas.add(
                        UserInfo(
                            document_id = document_id,
                            name = data.name,
                            email = data.email,
                            address = data.address,
                            mobile = data.mobile,
                            father = data.father,
                            mother = data.mother,
                            city = data.city,
                            country = data.country,
                            postal = data.postal,
                            company = data.company
                        )
                    )
                }

                storedata()
                Log.d(TAG, "onCreate:")
            }.addOnFailureListener {
                Log.d(TAG, "Error getting documents: ")
            }
    }

    private fun storedata() {
        recyclerview1.layoutManager = StaggeredGridLayoutManager(1, RecyclerView.VERTICAL)
        recyclerview1.adapter =
            MyAdapter(context as LoadDataActivity, mDatas, context as LoadDataActivity)
        Log.d(TAG, "RecyclerViewAccept:")
    }

}

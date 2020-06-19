package com.example.firebasereadwrite.loaddata

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import com.example.firebasereadwrite.R
import com.example.firebasereadwrite.userInfo.UserInfo
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.load_data_fragment.*

class LoadDataFragment : Fragment() {

    companion object {
        fun newInstance() = LoadDataFragment()
    }
    private lateinit var firestore: FirebaseFirestore
    private lateinit var viewModel: LoadDataViewModel
    private var mDatas = ArrayList<UserInfo>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.load_data_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoadDataViewModel::class.java)
        // TODO: Use the ViewModel
        firestore= FirebaseFirestore.getInstance()
        firestore.collection("user").get()
            .addOnSuccessListener { document->
                val data=document.toObjects(UserInfo::class.java)
                storedata(data)

            }

    }

     private  fun storedata(data:List<UserInfo> ) {
            for (i in data){
                mDatas.add(i)
            }
        recyclerview.layoutManager=StaggeredGridLayoutManager(1,RecyclerView.VERTICAL)
    recyclerview.adapter=com.example.firebasereadwrite.adapter.MyAdapter(this.mDatas)
     }

}

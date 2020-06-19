package com.example.firebasereadwrite.alldatarecyclerview

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firebasereadwrite.R

class AllDataRecyclerviewFragment : Fragment()  {

    companion object {
        fun newInstance() = AllDataRecyclerviewFragment()
    }

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

        val key=context .

    }


}
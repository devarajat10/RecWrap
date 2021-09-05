package com.example.recwrap.items

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.recwrap.model.PeopleModel
import com.example.recwrap.R
import com.example.recwrap.databinding.FourthlistMainBinding
import com.example.recwrap.databinding.SecondlistMainBinding
import com.example.recwrapper.IRecAdapter
import com.example.recwrapper.ItemInflater

class Item4(recAdapter: IRecAdapter, var arrayList: ArrayList<PeopleModel>) :
    ItemInflater(recAdapter,R.layout.fourthlist_main) {
    


    override fun onBindData(position: Int, dataBinding: ViewDataBinding) {
        (dataBinding as FourthlistMainBinding).item=arrayList[position]
    }


}
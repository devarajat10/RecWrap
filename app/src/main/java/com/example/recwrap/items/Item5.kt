package com.example.recwrap.items

import androidx.databinding.ViewDataBinding
import com.example.recwrap.model.PeopleModel
import com.example.recwrap.R
import com.example.recwrap.databinding.FifthlistMainBinding
import com.example.recwrapper.IRecAdapter
import com.example.recwrapper.ItemInflater

class Item5(recAdapter: IRecAdapter, var arrayList: ArrayList<PeopleModel>) :
    ItemInflater(recAdapter,R.layout.fifthlist_main) {


    override fun onBindData(position: Int, dataBinding: ViewDataBinding) {
        (dataBinding as FifthlistMainBinding).item = arrayList[position]
    }

}
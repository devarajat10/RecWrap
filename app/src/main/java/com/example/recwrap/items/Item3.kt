package com.example.recwrap.items

import androidx.databinding.ViewDataBinding
import com.example.recwrap.model.PeopleModel
import com.example.recwrap.R
import com.example.recwrap.databinding.ThirdlistMainBinding
import com.example.recwrapper.IRecAdapter
import com.example.recwrapper.ItemInflater
import java.util.*

class Item3(recAdapter: IRecAdapter, var arrayList: ArrayList<PeopleModel>) :
    ItemInflater(recAdapter,R.layout.thirdlist_main) {

    override fun onBindData(position: Int, dataBinding: ViewDataBinding) {
        (dataBinding as ThirdlistMainBinding).item=arrayList[position]
    }


}
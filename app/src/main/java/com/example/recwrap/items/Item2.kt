package com.example.recwrap.items

import androidx.databinding.ViewDataBinding
import com.example.recwrap.model.PeopleModel
import com.example.recwrap.R
import com.example.recwrap.databinding.SecondlistMainBinding
import com.example.recwrap.model.TeamsModel
import com.example.recwrapper.IRecAdapter
import com.example.recwrapper.ItemInflater
import java.util.*

class Item2(recAdapter: IRecAdapter, var arrayList: ArrayList<TeamsModel>) :
    ItemInflater(recAdapter,R.layout.secondlist_main) {


    override fun onBindData(position: Int, dataBinding: ViewDataBinding) {
        (dataBinding as SecondlistMainBinding).item=arrayList[position]
    }

    override var itemCount = arrayList.size                                         // Provide the array size for total elements count

}
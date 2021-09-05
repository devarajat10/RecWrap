package com.example.recwrap.items

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.recwrap.model.PeopleModel
import com.example.recwrap.R
import com.example.recwrap.databinding.ListitemMainBinding
import com.example.recwrapper.IRecAdapter
import com.example.recwrapper.ItemInflater


class Item1(recAdapter: IRecAdapter, var arrayList: ArrayList<PeopleModel>) :
    ItemInflater(recAdapter,R.layout.listitem_main) {                               // provide the layout

    override fun onBindData(position: Int, dataBinding: ViewDataBinding) {
        (dataBinding as ListitemMainBinding).item = arrayList[position]             // Bind data with layout (Type casting needed)
    }

    override var itemCount = arrayList.size                                         // Provide the array size for total elements count


}
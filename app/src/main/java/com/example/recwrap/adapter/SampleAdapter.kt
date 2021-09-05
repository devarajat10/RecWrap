package com.example.recwrap.adapter

import android.content.Context
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.LENGTH_SHORT
import com.example.recwrap.items.*
import com.example.recwrap.model.PeopleModel
import com.example.recwrapper.RecAdapter

class SampleAdapter(private val context: Context, array: ArrayList<PeopleModel>) : RecAdapter() {

    init {
        addAllInflater(Item1(this,array), Item2(this,array),
            Item3(this,array), Item4(this,array), Item5(this,array)   // add all items in the order you want to implement
                                                                                                         // the logic i.e return 0 for Item 1 adapter
                                                                                                         // in getItemViewType()
        )
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(context,"Item clicked is $position", LENGTH_SHORT).show()

    }
    override fun getItemViewType(position: Int): Int {
       return position%5                                                                                   // We can either override the logic or
                                                                                                           // use the basic implementation of showing Items in order
                                                                                                           // they are added in inflater Line 14
    }
}
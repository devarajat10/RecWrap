package com.example.recwrapper

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class ItemInflater(private var iRecAdapter: IRecAdapter,val layout:Int) {
    abstract fun onBindData(position: Int, dataBinding: ViewDataBinding)

    open var itemCount: Int=0

    fun notifyDataSetChanged() {
        notifyItemRangeChanged(0, itemCount)
    }


   internal fun newViewHolder(parent: ViewGroup): ItemViewHolder {
        val dataBinding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            layout, parent, false
        )
        return ItemViewHolder(dataBinding)

    }

    private fun notifyItemRangeChanged(positionStart: Int, itemCount: Int) {
        (iRecAdapter).notifyItemRangeChanged(this, positionStart, itemCount)
    }

    inner class ItemViewHolder(binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var mDataBinding: ViewDataBinding = binding

    }
}


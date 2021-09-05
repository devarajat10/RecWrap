package com.example.recwrapper

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class IRecAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return getItemInflater(viewType).newViewHolder(parent)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val itemPosition: Int = getItemPosition(position)
        getItemInflater(viewHolder.itemViewType).onBindData(
            itemPosition,
            (viewHolder as ItemInflater.ItemViewHolder).mDataBinding
        )

        viewHolder.mDataBinding.getRoot()
            .setOnClickListener{
                onItemClick(position)
            }
    }

    abstract fun onItemClick(position: Int)

    abstract override fun getItemCount(): Int

    abstract override fun getItemViewType(position: Int): Int

    abstract fun getItemInflater(viewType: Int): ItemInflater

    abstract fun getPosition(itemInflater: ItemInflater, itemPosition: Int): Int

    abstract fun getItemPosition(position: Int): Int

    abstract fun notifyItemRangeChanged(
        itemInflater: ItemInflater, positionStart: Int,
        itemCount: Int
    )




}

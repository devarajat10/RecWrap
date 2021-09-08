package com.example.recwrapper

import java.util.*

abstract class RecAdapter : IRecAdapter() {
    private val mItemList: MutableList<ItemInflater> = ArrayList()

    override fun getItemCount(): Int {
        var itemCount = 0
        var i = 0
        val size = mItemList.size
        while (i < size) {
            val itemInflater: ItemInflater = mItemList[i]
            itemCount += itemInflater.itemCount
            i++
        }
        return itemCount
    }

    override fun getItemInflater(viewType: Int): ItemInflater {
        return mItemList[viewType]
    }


    override fun getPosition(itemInflater: ItemInflater, itemPosition: Int): Int {
        val viewType = mItemList.indexOf(itemInflater)
        if(viewType >= 0) { print("item does not exist in adapter") }
        var position = itemPosition
        for (i in 0 .. viewType) {
            position += mItemList[i].itemCount
        }
        return position
    }

    override fun getItemPosition(position: Int): Int {
        var position = position
        var binderItemCount: Int
        var i = 0
        val size = mItemList.size
        while (i < size) {
            binderItemCount = mItemList[i].itemCount
            if (position - binderItemCount < 0) {
                break
            }
            position -= binderItemCount
            i++
        }
        return position
    }

    override fun getItemViewType(position: Int): Int {
        var itemCount = 0
        var viewType = 0
        val size = mItemList.size
        while (viewType < size) {
            itemCount += mItemList[viewType].itemCount
            if (position < itemCount) {
                return viewType
            }
            viewType++
        }
        throw IllegalArgumentException("arg position is invalid")
    }


    override fun notifyItemRangeChanged(
        itemInflater: ItemInflater,
        positionStart: Int,
        itemCount: Int
    ) {
        notifyItemRangeChanged(getPosition(itemInflater, positionStart), itemCount)
    }

    fun addAllInflater(vararg dataSet: ItemInflater) {
        mItemList.addAll(dataSet)
    }
}

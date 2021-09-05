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
        check(viewType >= 0) { "item does not exist in adapter" }
        var position = itemPosition
        for (i in 0 until viewType) {
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

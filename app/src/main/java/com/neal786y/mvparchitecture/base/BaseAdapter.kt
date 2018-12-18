package com.dev.neal786y.mvpsample.base

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

 abstract class BaseAdapter<O : Any, T : BaseViewHolder<O>> : RecyclerView.Adapter<T>() {

     val listOfItems = arrayListOf<O>()

    abstract fun getViewHolder(viewGroup: ViewGroup, viewType: Int): T

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): T {
        return getViewHolder(viewGroup, viewType)
    }

    override fun getItemCount(): Int = listOfItems.size

     fun addAll(list: List<O>?){
         list?.let {
             listOfItems.clear()
             listOfItems.addAll(list)
             notifyChange()
         }
     }

     fun getList(): List<O> = listOfItems

     fun appendList(list: List<O>?){
         list?.let {
             listOfItems.addAll(list)
             notifyChange()
         }

     }

     fun clearData() {
         this.listOfItems.clear()
         notifyChange()
     }


     fun add(o: O?) {
         o?.let {
             listOfItems.add(o)
             notifyChange()
         }
     }

     fun getListSize(): Int {
         return listOfItems.size
     }

     @Synchronized
     fun notifyChange() {
         super.notifyDataSetChanged()
     }


}
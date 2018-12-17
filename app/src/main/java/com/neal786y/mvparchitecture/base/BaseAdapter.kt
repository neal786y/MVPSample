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

    override fun onBindViewHolder(viewHolder: T, position: Int) {
        viewHolder.loadData(listOfItems.get(position))
    }

     fun addAll(list: List<O>){
         listOfItems.clear()
         listOfItems.addAll(list)
         notifyChange()
     }

     fun getList(): List<O> = listOfItems

     fun appendList(list: List<O>){
         listOfItems.addAll(list)
         notifyChange()
     }

     fun clearData() {
         this.listOfItems.clear()
         notifyChange()
     }


     fun add(o: O) {
         listOfItems.add(o)
         notifyChange()
     }

     fun getListSize(): Int {
         return listOfItems.size
     }

     @Synchronized
     fun notifyChange() {
         super.notifyDataSetChanged()
     }


}
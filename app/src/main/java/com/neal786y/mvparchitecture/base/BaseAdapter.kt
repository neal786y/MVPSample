//package com.dev.neal786y.mvpsample.base
//
//import android.support.v7.widget.RecyclerView
//import android.view.ViewGroup
//
//abstract class BaseAdapter<T, V> : RecyclerView.Adapter<BaseViewHolder<V>>() {
//
//    val listOfItems = arrayListOf<T>()
//
//    abstract fun getViewHolder(viewGroup: ViewGroup): BaseViewHolder<V>
//
//    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BaseViewHolder<V> {
//        return getViewHolder(viewGroup)
//    }
//
//    override fun getItemCount(): Int = listOfItems.size
//
//    override fun onBindViewHolder(viewHolder: BaseViewHolder<V>, position: Int) {
//        viewHolder.loadData(listOfItems.get(position))
//    }
//}
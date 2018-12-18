package com.neal786y.mvparchitecture.main.adaper

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dev.neal786y.mvpsample.base.BaseAdapter
import com.neal786y.mvparchitecture.R
import com.neal786y.mvparchitecture.main.viewholder.SourceViewHolder

class SourceAdapter : BaseAdapter<String, SourceViewHolder>() {
    override fun onBindViewHolder(holder: SourceViewHolder, position: Int) {
        holder.loadData(listOfItems.get(position))
        holder.itemView.setOnClickListener {
            onSourceItemClickListener?.onSourceClick(listOfItems.get(position))
        }
    }

    override fun getViewHolder(viewGroup: ViewGroup, viewType: Int): SourceViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val view = inflater.inflate(R.layout.source_row, viewGroup, false)
        return SourceViewHolder(view)
    }

    var onSourceItemClickListener: OnSourceItemClickListener? = null

    interface OnSourceItemClickListener {
        fun onSourceClick(source: String)
    }
}
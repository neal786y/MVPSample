package com.neal786y.mvparchitecture.main.viewholder

import android.view.View
import com.dev.neal786y.mvpsample.base.BaseViewHolder
import kotlinx.android.synthetic.main.source_row.view.*

class SourceViewHolder(itemView: View) : BaseViewHolder<String>(itemView) {

    override fun loadData(data: String?) {
        data?.let {
            itemView.textView.setText(data)
        }
    }
}
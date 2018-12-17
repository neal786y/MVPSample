package com.neal786y.mvparchitecture.main.viewholder

import android.view.View
import com.dev.neal786y.mvpsample.base.BaseViewHolder
import com.neal786y.mvparchitecture.base.loadImageUrl
import com.neal786y.mvparchitecture.main.pojo.NewsResponse
import kotlinx.android.synthetic.main.article_row.view.*

class NewsItemViewHolder(itemView: View) : BaseViewHolder<NewsResponse.Article>(itemView) {

    override fun loadData(data: NewsResponse.Article) {

        itemView.imageView.loadImageUrl(data.urlToImage)
        itemView.textViewTitle.setText(data.title)
        itemView.textViewDescription.setText(data.description)
        itemView.textViewContent.setText(data.content)
    }
}
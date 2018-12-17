package com.neal786y.mvparchitecture.main.viewholder

import android.content.Intent
import android.view.View
import com.dev.neal786y.mvpsample.base.BaseViewHolder
import com.neal786y.mvparchitecture.base.loadImageUrl
import com.neal786y.mvparchitecture.main.activity.DetailWebActivity
import com.neal786y.mvparchitecture.main.pojo.NewsResponse
import kotlinx.android.synthetic.main.article_row.view.*

class NewsItemViewHolder(itemView: View) : BaseViewHolder<NewsResponse.Article>(itemView) {

    override fun loadData(data: NewsResponse.Article) {

        itemView.imageView.loadImageUrl(data.urlToImage)
        itemView.textViewTitle.setText(data.title)
        itemView.textViewDescription.setText(data.description)
        itemView.cardView.setOnClickListener {
            val intent = Intent(itemView.context, DetailWebActivity::class.java)
            intent.putExtra("detailUrl", data.url)
            itemView.context.startActivity(intent)
        }
    }
}
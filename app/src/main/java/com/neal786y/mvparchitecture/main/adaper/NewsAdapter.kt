package com.neal786y.mvparchitecture.main.adaper

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dev.neal786y.mvpsample.base.BaseAdapter
import com.neal786y.mvparchitecture.R
import com.neal786y.mvparchitecture.main.pojo.NewsResponse
import com.neal786y.mvparchitecture.main.viewholder.NewsItemViewHolder

class NewsAdapter : BaseAdapter<NewsResponse.Article, NewsItemViewHolder>() {

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        holder.loadData(listOfItems.get(position))
    }

    override fun getViewHolder(viewGroup: ViewGroup, viewType: Int): NewsItemViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val view = inflater.inflate(R.layout.article_row, viewGroup, false)
        return NewsItemViewHolder(view)
    }
}
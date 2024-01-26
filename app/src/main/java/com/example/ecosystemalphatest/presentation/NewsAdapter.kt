package com.example.ecosystemalphatest.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecosystemalphatest.databinding.ActivityMainBinding
import com.example.ecosystemalphatest.databinding.NewsItemBinding
import com.example.ecosystemalphatest.domain.models.NewsArticle
import com.squareup.picasso.Picasso

class NewsAdapter(private val newsList: List<NewsArticle>): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(viewHolder: NewsViewHolder, position: Int) {
        val newsItem = newsList[position]
        viewHolder.apply {
            binding.apply {
                val newsResponseImage = newsItem.multimedia.firstOrNull { it.height == 400 && it.width == 600} ?: newsItem.multimedia.first()
                Picasso.get().load(newsResponseImage.url).resize(600, 400).centerCrop().into(newsImage)
                tvTitle.text = newsItem.title
                tvDescription.text = newsItem.abstract
                tvByLine.text = newsItem.byline
                tvDatetime.text = newsItem.published_date
            }
        }
    }

    inner class NewsViewHolder(val binding: NewsItemBinding): RecyclerView.ViewHolder(binding.root)

}
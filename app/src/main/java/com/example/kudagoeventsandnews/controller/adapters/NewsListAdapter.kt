package com.example.kudagoeventsandnews.controller.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kudagoeventsandnews.views.items.News
import com.example.kudagoeventsandnews.databinding.NewsItemBinding

class NewsListAdapter(private val items: List<News>, private var activity: FragmentActivity?) : RecyclerView.Adapter<NewsListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NewsItemBinding.inflate(inflater)
        binding.item.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class MyViewHolder(val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: News) {
            binding.news = item
            binding.executePendingBindings()
        }
    }
}
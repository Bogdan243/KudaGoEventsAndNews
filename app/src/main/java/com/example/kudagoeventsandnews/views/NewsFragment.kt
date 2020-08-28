package com.example.kudagoeventsandnews.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.kudagoeventsandnews.R
import com.example.kudagoeventsandnews.views.items.News
import com.example.kudagoeventsandnews.controller.adapters.NewsListAdapter
import com.example.kudagoeventsandnews.databinding.FragmentNewsBinding


class NewsFragment : Fragment() {
    private lateinit var binding: FragmentNewsBinding
    private lateinit var newsListAdapter: NewsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_news, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsListAdapter = NewsListAdapter(listOf<News>(News("string"), News("string2")),activity)
        binding.newsList.adapter = newsListAdapter
    }

}
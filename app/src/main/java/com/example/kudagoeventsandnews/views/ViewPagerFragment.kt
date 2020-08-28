package com.example.kudagoeventsandnews.views

import com.example.kudagoeventsandnews.controller.adapters.NewsAndEventsAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.kudagoeventsandnews.R
import com.example.kudagoeventsandnews.databinding.FragmentViewPagerBinding


class ViewPagerFragment : Fragment() {
    private var fragmentList = mutableListOf<Fragment>(EventsFragment(), NewsFragment())
    lateinit var fragmetsAdapter: NewsAndEventsAdapter
    lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_view_pager, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        fragmetsAdapter = NewsAndEventsAdapter(this,fragmentList)
        binding.newsAndEventsPager.adapter = fragmetsAdapter
    }


}
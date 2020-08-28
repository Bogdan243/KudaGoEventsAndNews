package com.example.kudagoeventsandnews.controller.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kudagoeventsandnews.views.ViewPagerFragment

class NewsAndEventsAdapter(
    fragment: ViewPagerFragment,
    private var fragmentList: MutableList<Fragment>
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment {
        val nextFragment = fragmentList[position]
        return nextFragment
    }
}
package com.example.kudagoeventsandnews.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kudagoeventsandnews.R
import com.example.kudagoeventsandnews.views.items.Event
import com.example.kudagoeventsandnews.model.NewsAndEventsViewModel
import com.example.kudagoeventsandnews.controller.adapters.EventsListAdapter
import com.example.kudagoeventsandnews.databinding.FragmentEventsBinding


class EventsFragment : Fragment() {
    private lateinit var binding: FragmentEventsBinding
    private lateinit var eventListAdapter: EventsListAdapter
    private lateinit var newsAndEventsViewModel: NewsAndEventsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_events, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        newsAndEventsViewModel.liveDataEventList.observe(viewLifecycleOwner, Observer { setEventAdapter(it) })
    }

    private fun setEventAdapter(eventList: List<Event>) {
        eventListAdapter = EventsListAdapter(eventList,activity)
        binding.eventsList.adapter = eventListAdapter
    }

    private fun initViewModel() {
        newsAndEventsViewModel = ViewModelProvider(requireActivity()).get(NewsAndEventsViewModel::class.java)
    }

}
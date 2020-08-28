package com.example.kudagoeventsandnews.controller.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kudagoeventsandnews.databinding.EventItemBinding
import com.example.kudagoeventsandnews.views.items.Event


class EventsListAdapter(private val items: List<Event>, private var activity: FragmentActivity?) : RecyclerView.Adapter<EventsListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = EventItemBinding.inflate(inflater)
        binding.item.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class MyViewHolder(private val binding: EventItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Event) {
            binding.event = item
            binding.executePendingBindings()
        }
    }
}
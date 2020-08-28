package com.example.kudagoeventsandnews.widget

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.example.kudagoeventsandnews.R
import com.example.kudagoeventsandnews.views.items.Event


class WidgetRemoteFactory(private val applicationContext: Context,private val intent: Intent) :
    RemoteViewsService.RemoteViewsFactory {

    private var widgetID = 0
    private lateinit var eventList : MutableList<Event>


    override fun onCreate() {
        Log.i("Factory","Create factory")

        widgetID = intent.getIntExtra(
            AppWidgetManager.EXTRA_APPWIDGET_ID,
            AppWidgetManager.INVALID_APPWIDGET_ID
        )
    }

    override fun getCount(): Int {
        return eventList.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getLoadingView(): RemoteViews? {
        return null
    }

    override fun getViewAt(position: Int): RemoteViews? {
        val rView = RemoteViews(
            applicationContext.packageName,
            R.layout.widget_item
        )
        rView.setTextViewText(R.id.itemText, eventList[position].title)
        return rView
    }

    override fun getViewTypeCount(): Int {
        return 1
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun onDataSetChanged() {
        Log.i("Factory","Get and set data list")
        val widgetInternetRequest = WidgetInternetRequest()
        eventList = widgetInternetRequest.makeNetworkRequestAndSetEventList()
    }

    override fun onDestroy() {}


}
package com.example.kudagoeventsandnews.widget

import android.content.Intent
import android.util.Log
import android.widget.RemoteViewsService
import com.example.kudagoeventsandnews.widget.WidgetRemoteFactory

class EventListService : RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent): RemoteViewsFactory {
        Log.i("Service", "Start service")
        return WidgetRemoteFactory(application, intent)
    }
}
package com.example.kudagoeventsandnews.widget


import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.example.kudagoeventsandnews.R
import java.text.SimpleDateFormat
import java.util.*


class EventListWidgetProvider : AppWidgetProvider() {
    var sdf: SimpleDateFormat = SimpleDateFormat("HH:mm:ss")
    override fun onUpdate(
        context: Context, appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        for (i in appWidgetIds) {
            updateWidget(context, appWidgetManager, i)
        }
    }

    private fun updateWidget(
        context: Context, appWidgetManager: AppWidgetManager,
        appWidgetId: Int
    ) {
        val rv = RemoteViews(
            context.packageName,
            R.layout.widget
        )
        setTv(rv, context, appWidgetId)
//        setUpdateTV(rv, context, appWidgetId)
        setList(rv, context, appWidgetId)
        appWidgetManager.updateAppWidget(appWidgetId, rv)
    }

    fun setUpdateTV(rv: RemoteViews, context: Context?, appWidgetId: Int) {
        val updIntent = Intent(context, EventListWidgetProvider::class.java)
        updIntent.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
        updIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, intArrayOf(appWidgetId))
        val updPIntent = PendingIntent.getBroadcast(
            context,
            appWidgetId, updIntent, 0
        )
        rv.setOnClickPendingIntent(R.id.tvUpdate, updPIntent)
    }

    private fun setTv(rv: RemoteViews, context: Context?, appWidgetId: Int) {
        rv.setTextViewText(
            R.id.tvUpdate,
            sdf.format(Date(System.currentTimeMillis()))
        )
    }

    private fun setList(rv: RemoteViews, context: Context?, appWidgetId: Int) {
        val adapter = Intent(context, EventListService::class.java)
        adapter.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
        rv.setRemoteAdapter(R.id.lvList, adapter)
    }
}
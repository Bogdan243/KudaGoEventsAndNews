package com.example.kudagoeventsandnews.widget

import android.util.Log
import com.example.kudagoeventsandnews.model.InternetRequester
import com.example.kudagoeventsandnews.model.parsers.EventParser
import com.example.kudagoeventsandnews.views.items.Event

class WidgetInternetRequest {

    private var pageSize = 50
    private var itemInOnePage = 19
    private var page = (pageSize / itemInOnePage).toInt()

    private val kudaGoEvents = InternetRequester()
    private var eventList = mutableListOf<Event>()

    private val eventListURL =
        "https://kudago.com/public-api/v1.4/events/?lang=ru&page_size=${pageSize}&page=${page}&fields=place,dates&expand=place&order_by=publication_date&location=spb"

    fun makeNetworkRequestAndSetEventList(): MutableList<Event> {

        Log.i("InternetRequest", "Create internet request from widget")

        var JSONString = ""
        for (i in 0..page) {
            JSONString += kudaGoEvents.requestDataListWithoutCorutine(eventListURL)
        }

        var eventParser = EventParser(JSONString, pageSize)
        eventList = eventParser.parseObjAndReturnList()

        return eventList
    }


}
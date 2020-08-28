package com.example.kudagoeventsandnews.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kudagoeventsandnews.model.parsers.EventParser
import com.example.kudagoeventsandnews.views.items.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsAndEventsViewModel : ViewModel() {
    private val kudaGoEvents = InternetRequester()
    var liveDataEventList = MutableLiveData<MutableList<Event>>()

    private var pageSize = 50
    private var itemInOnePage = 19
    private var page = (pageSize/itemInOnePage).toInt()

    fun makeNetworkRequestAndSetEventList() {
        val eventListURL =
            "https://kudago.com/public-api/v1.4/events/?lang=ru&page_size=${pageSize}&page=${page}&fields=place,dates&expand=place&order_by=publication_date&location=spb"
        viewModelScope.launch(Dispatchers.IO) {
            Log.i("InternetRequest", "Create request")
            var JSONString = ""
            for(i in 0..page) {
                JSONString += kudaGoEvents.requestDataList(eventListURL)
            }
            setAndParseEventJSONString(JSONString,pageSize)
        }
    }

    private fun setAndParseEventJSONString(jsonString: String, pageSize: Int) {
        var eventParser = EventParser(jsonString,pageSize)
        var eventList = eventParser.parseObjAndReturnList()
        liveDataEventList.postValue(eventList)
    }

}
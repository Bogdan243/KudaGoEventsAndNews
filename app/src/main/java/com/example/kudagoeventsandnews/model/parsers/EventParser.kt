package com.example.kudagoeventsandnews.model.parsers

import com.example.kudagoeventsandnews.views.items.Event
import org.json.JSONObject

class EventParser(jsonString: String,var pageSize: Int) {
    private var JSONObject = JSONObject()
    private var eventList = mutableListOf<Event>()

    init {
        JSONObject = JSONObject(jsonString)
    }

    //обработать исключение при поиске в объекте
    fun parseObjAndReturnList(): MutableList<Event> {
        var results = JSONObject.getJSONArray("results")
        for (counter in 0..(pageSize-1)) {
            var place = JSONObject(results[counter].toString()).getString("place")

            if (place != "null") {
                var title = JSONObject(place).getString("title")
                var addres = JSONObject(place).getString("subway")
                eventList.add(Event(title, addres, "", ""))
            }

        }

        return eventList
    }
}
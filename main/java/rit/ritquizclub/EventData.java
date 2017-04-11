package rit.ritquizclub;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 03-03-2016.
 */
public class EventData {
    Context mContext;
    List<String> titleList, detailsList, dayList, monthList;

    EventData(Context context, List<String> titleList, List<String> detailsList, List<String> dayList, List<String> monthList) {
        this.mContext = context;
        this.titleList = titleList;
        this.detailsList = detailsList;
        this.dayList = dayList;
        this.monthList = monthList;
    }

    public ArrayList<Event> eventList() {
        ArrayList<Event> list = new ArrayList<>();
        for (int i = 0; i < titleList.size(); i++) {
            Event event = new Event();
            event.title = titleList.get(i);
            event.details = detailsList.get(i);
            event.day = dayList.get(i);
            event.month = monthList.get(i);
            event.imageName = "image1";
            list.add(event);
        }
        return (list);
    }
}

package rit.ritquizclub;

import android.app.Application;

import java.util.List;

/**
 * Created by Admin on 23-03-2016.
 */
public class MyApplication extends Application {

    List<String> titleArray = null;
    List<String> detailsArray = null;
    List<String> dayArray = null;
    List<String> monthArray = null;

    public List<String> getTitleArray() {
        return titleArray;
    }

    public List<String> getDetailsArray() {
        return detailsArray;
    }

    public List<String> getDayArray() {
        return dayArray;
    }

    public List<String> getMonthArray() {
        return monthArray;
    }

    public void setArrays(List<String> titleArray, List<String> detailsArray, List<String> dayArray, List<String> monthArray) {
        this.titleArray = titleArray;
        this.detailsArray = detailsArray;
        this.dayArray = dayArray;
        this.monthArray = monthArray;
    }
}

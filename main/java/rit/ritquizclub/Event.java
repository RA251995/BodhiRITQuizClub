package rit.ritquizclub;

import android.content.Context;

/**
 * Created by Admin on 03-03-2016.
 */
public class Event {
    public String title;
    public String details;
    public String imageName;
    public String day;
    public String month;

    public int getImageResourceId(Context context) {
        return context.getResources().getIdentifier(this.imageName, "drawable", context.getPackageName());
    }
}

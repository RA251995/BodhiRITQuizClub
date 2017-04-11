package rit.ritquizclub;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class EventsListAdapter extends RecyclerView.Adapter<EventsListAdapter.ViewHolder> {

    Context mContext;
    List<String> titleList, detailsList, dayList, monthList;

    public EventsListAdapter(Context context, List<String> titleList, List<String> detailsList, List<String> dayList, List<String> monthList) {
        this.mContext = context;
        this.titleList = titleList;
        this.detailsList = detailsList;
        this.dayList = dayList;
        this.monthList = monthList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_events, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Event event = new EventData(mContext, titleList, detailsList, dayList, monthList).eventList().get(position);
        holder.eventTitle.setText(event.title);
        holder.eventDetails.setText(event.details.replace("\\n", "\n"));
        holder.eventDay.setText(event.day);
        holder.eventMonth.setText(event.month);
        Picasso.with(mContext).load(event.getImageResourceId(mContext)).into(holder.eventImage);
    }

    @Override
    public int getItemCount() {
        return new EventData(mContext, titleList, detailsList, dayList, monthList).eventList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout mainHolder;
        public LinearLayout eventHolder;
        public TextView eventTitle;
        public TextView eventDetails;
        public TextView eventDay;
        public TextView eventMonth;
        public ImageView eventImage;

        public ViewHolder(View itemView) {
            super(itemView);
            mainHolder = (LinearLayout) itemView.findViewById(R.id.mainHolder);
            eventTitle = (TextView) itemView.findViewById(R.id.eventTitle);
            eventDetails = (TextView) itemView.findViewById(R.id.eventDetails);
            eventHolder = (LinearLayout) itemView.findViewById(R.id.eventHolder);
            eventDay = (TextView) itemView.findViewById(R.id.eventDay);
            eventMonth = (TextView) itemView.findViewById(R.id.eventMonth);

            eventImage = (ImageView) itemView.findViewById(R.id.eventImage);
        }

    }


}

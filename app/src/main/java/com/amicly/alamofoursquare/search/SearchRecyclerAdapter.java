package com.amicly.alamofoursquare.search;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amicly.alamofoursquare.R;
import com.amicly.alamofoursquare.model.Event;

import java.util.List;

/**
 * Created by darrankelinske on 1/30/18.
 */

public class SearchRecyclerAdapter extends RecyclerView.Adapter<SearchRecyclerAdapter.EventViewHolder> {

    private List<Event> events;
    private EventClickListener eventClickListener;

    public SearchRecyclerAdapter(List<Event> events, EventClickListener eventClickListener) {
        this.events = events;
        this.eventClickListener = eventClickListener;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent,
                false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        final Event event = events.get(position);

        holder.itemView.setOnClickListener(v -> eventClickListener.onClick(event));

        holder.eventNameTextView.setText(event.getTitle());
        holder.eventLocationTextView.setText(event.getVenue().getDisplayLocation());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    @Override
    public void onViewRecycled(EventViewHolder holder) {
        super.onViewRecycled(holder);
    }

    public void setEvents(List<Event> events) {
        this.events = events;
        notifyDataSetChanged();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {

        private ImageView eventImageView;
        private TextView eventNameTextView;
        private TextView eventLocationTextView;
        private TextView eventDateTextView;

        public EventViewHolder(View itemView) {
            super(itemView);
            eventImageView = itemView.findViewById(R.id.image_view_event_image);
            eventNameTextView = itemView.findViewById(R.id.text_view_event_name);
            eventLocationTextView = itemView.findViewById(R.id.text_view_event_location);
            eventDateTextView = itemView.findViewById(R.id.text_view_event_date);
        }
    }

    public interface EventClickListener {
        void onClick(Event event);
    }
}

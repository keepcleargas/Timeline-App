package com.fabula.android.timeline.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.accounts.Account;
import android.location.Location;
import android.net.Uri;
import android.provider.BaseColumns;

import com.fabula.android.timeline.database.providers.EventProvider;

public class Event extends BaseEvent {
	
	private List<EventItem> eventItems;
	private List<Emotion> emotionList;
	
	public Event(){
		className = this.getClass().getSimpleName();
		setTags(new ArrayList<String>());
	}
	
	public Event(String exID, Location location, Account user) {
		super(exID, location, user);
		eventItems = new ArrayList<EventItem>();
		emotionList = new ArrayList<Emotion>();
		className = this.getClass().getSimpleName();
		setTags(new ArrayList<String>());
	}
	
	public Event(String id, String exID, Date dateTime, Location location, Account user) {
		super(id, exID, dateTime, location, user);
		eventItems = new ArrayList<EventItem>();
		emotionList = new ArrayList<Emotion>();
		className = this.getClass().getSimpleName();
		setTags(new ArrayList<String>());
	}
	
	public void addEventItem(EventItem evItem){
		eventItems.add(evItem);
	}
	
	public List<EventItem> getEventItems() {
		if(eventItems==null)
			eventItems = new ArrayList<EventItem>();
		return eventItems;
	}
	public void setEventItems(List<EventItem> eventItems) {
		this.eventItems = eventItems;
	}
	
	public void addEmotion(Emotion emotion){
		emotionList.add(emotion);
	}
	
	public List<Emotion> getEmotionList() {
		if(emotionList==null)
			emotionList = new ArrayList<Emotion>();
		return emotionList;
	}

	public void setEmotionList(List<Emotion> emotionList) {
		this.emotionList = emotionList;
	}
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public static final class EventColumns implements BaseColumns {
		
		private EventColumns(){}
		public static final Uri CONTENT_URI = Uri.parse("content://" +EventProvider.AUTHORITY+ "/events");
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.fabula.events";
		public static final String EVENT_EXPERIENCEID = "experienceid";
		public static final String EVENT_LOCATION_LAT = "latitude";
		public static final String EVENT_LOCATION_LNG = "longitude";
		public static final String EVENT_TITLE = "event_title";
		public static final String EVENT_ITEMS_ID = "event_items_id";
		public static final String IS_SHARED = "event_is_shared";
		public static final String CREATOR = "event_creator";
		public static final String MOOD = "mood";
	}
	
}

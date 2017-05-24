package com.deicos.magnolia.data.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * backoffice-magnolia
 * com.deicos.magnolia.data.generic
 * Created by Alberto Soto Fernandez in 24/05/2017.
 * Description:
 */
public class FullCalendarWrapper {
    List<FullCalendarEvent> events = new ArrayList<>();

    public List<FullCalendarEvent> getEvents() {
        return events;
    }

    public void setEvents(List<FullCalendarEvent> events) {
        this.events = events;
    }
}

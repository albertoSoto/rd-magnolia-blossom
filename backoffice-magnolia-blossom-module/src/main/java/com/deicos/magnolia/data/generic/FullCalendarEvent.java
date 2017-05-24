package com.deicos.magnolia.data.generic;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * backoffice-magnolia
 * com.deicos.magnolia.data.generic
 * Created by Alberto Soto Fernandez in 24/05/2017.
 * Description:
 */
public class FullCalendarEvent {

    String title;
    Boolean allDay;

    @JsonFormat(pattern="yyyy-MM-dd")
    Date start;

    @JsonFormat(pattern="yyyy-MM-dd")
    Date end;

    String url;
    String backgroundColor;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getAllDay() {
        return allDay;
    }

    public void setAllDay(Boolean allDay) {
        this.allDay = allDay;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}

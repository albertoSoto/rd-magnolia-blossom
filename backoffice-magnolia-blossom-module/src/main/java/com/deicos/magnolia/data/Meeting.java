package com.deicos.magnolia.data;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * backoffice-magnolia
 * com.deicos.magnolia.data.company
 * Created by Alberto Soto Fernandez in 22/05/2017.
 * Description:
 */
public class Meeting {
    @JsonFormat(pattern="yyyy-MM-dd")
    public Date eventDate;
    public Employee person;

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Employee getPerson() {
        return person;
    }

    public void setPerson(Employee person) {
        this.person = person;
    }
}

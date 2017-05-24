package com.deicos.magnolia.spring.rest;

import com.deicos.magnolia.data.Meeting;
import com.deicos.magnolia.data.generic.FullCalendarEvent;
import com.deicos.magnolia.data.generic.FullCalendarWrapper;
import com.deicos.magnolia.spring.example.ExampleDataService;
import com.deicos.magnolia.spring.generic.BackOfficeController;
import com.deicos.magnolia.spring.service.MyCompanyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * backoffice-magnolia
 * com.deicos.magnolia.spring.rest
 * Created by Alberto Soto Fernandez in 22/05/2017.
 * Description:
 */
@RestController
@RequestMapping("/calendar")
public class CalendarController extends BackOfficeController {
    @Autowired
    protected MyCompanyDataService dataService;

    @RequestMapping(path = "/list", method = RequestMethod.GET , headers = "Accept=*/*")
    public ResponseEntity<FullCalendarWrapper> getActions(HttpServletRequest request, HttpServletResponse response){
        try{
            FullCalendarWrapper events = new FullCalendarWrapper();
            events.setEvents(dataService.getEventsForMeetings());
            return getResponse(events);
        }catch (Exception e){
            return getErrorResponse(null,e);
        }

    }

}

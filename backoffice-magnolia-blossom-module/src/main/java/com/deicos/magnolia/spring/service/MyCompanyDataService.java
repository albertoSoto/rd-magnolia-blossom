package com.deicos.magnolia.spring.service;

import com.deicos.magnolia.data.Employee;
import com.deicos.magnolia.data.Meeting;
import com.deicos.magnolia.data.WorkerCategory;
import com.deicos.magnolia.data.generic.FullCalendarEvent;
import com.deicos.magnolia.data.generic.HighChartsSerie;
import com.deicos.magnolia.data.generic.HighChartsWrapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.math3.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * backoffice-magnolia
 * com.deicos.magnolia.spring.service
 * Created by Alberto Soto Fernandez in 22/05/2017.
 * Description:
 * <p>
 * Silly and generic Spring service for showing data in this project
 */
@Service
public class MyCompanyDataService {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    private static LinkedList<Meeting> meetings = new LinkedList<>();
    private static LinkedList<WorkerCategory> workerCategories = new LinkedList<>();
    private static LinkedList<Employee> employees = new LinkedList<>();
    public static final Double MIN_SALARY = new Double(18000);
    public static final Double MAX_SALARY = new Double(80000);

    @PostConstruct
    private void init() {
        generateDummyData();
    }

    public LinkedList<Meeting> getMeetings() {
        return meetings;
    }

    public LinkedList<FullCalendarEvent> getEventsForMeetings() {
        LinkedList<FullCalendarEvent> rtn = new LinkedList<>();
        try {
            meetings.forEach((e) -> {
                FullCalendarEvent aux = new FullCalendarEvent();
                aux.setAllDay(true);
                aux.setStart(e.eventDate);
                aux.setTitle(String.format("Reunion con %s",e.getPerson().getName()));
                rtn.add(aux);
            });
        } catch (Exception e) {
            log.error("Loading events", e);
        }
        return rtn;
    }

    public LinkedList<WorkerCategory> getWorkerCategories() {
        return workerCategories;
    }

    public LinkedList<Employee> getEmployees() {
        return employees;
    }

    public HighChartsWrapper getSalaryStats() {
        HighChartsWrapper rtn = new HighChartsWrapper();
        final Pair<Integer, String> EMPTY_SERIES_VALUE = new Pair<>(-1, "Sin definir");
        try {
            //montamos eje X etiqueta y valores de series=>
            for (WorkerCategory data : workerCategories) {
                rtn.getxSeriesLabels().add(data.getName());
                HighChartsSerie serie = new HighChartsSerie();
                serie.setName(data.getName());
                employees.forEach((e) -> {
                    if (e.getLevel() == data) {
                        serie.getData().add(e.getSalary());
                    }
                });
                rtn.getSeries().add(serie);
            }
        } catch (Exception e) {
            log.error("Error en graficas ", e);
        }
        return rtn;
    }


    public Double getRandomNumber(Double start, Double end) {
        try {
            double random = new Random().nextDouble();
            return new Double(Math.round(start + (random * (end - start))));
        } catch (Exception e) {
            log.error("getRandomNumber", e);
        }
        return start;
    }

    private void generateDummyData() {
        try {
            if (workerCategories.isEmpty()) {
                workerCategories.add((new WorkerCategory("CEO")));
                workerCategories.add((new WorkerCategory("Recruiter")));
                workerCategories.add((new WorkerCategory("Coder")));
            }
            if (employees.isEmpty()) {

                for (int i = 0; i < 10; i++) {
                    Employee e = new Employee();
                    e.setName("Employee " + i);
                    e.setLevel(workerCategories.get(i % 3));
                    e.setGroup("Alpha Version");
                    e.setSalary(getRandomNumber(MIN_SALARY, MAX_SALARY));
                    employees.add(e);
                }
            }
            if (meetings.isEmpty()) {
                Date today = new Date();
                for (int i = 0; i < 10; i++) {
                    Meeting meeting = new Meeting();
                    meeting.setEventDate(DateUtils.addDays(today, i));
                    meeting.setPerson(employees.get(i % 5));
                    meetings.add(meeting);
                }
            }
        } catch (Exception e) {
            log.error("generateDummyData()", e);
        }

    }

}

package com.deicos.magnolia.spring.rest;

import com.deicos.magnolia.data.generic.HighChartsWrapper;
import com.deicos.magnolia.spring.generic.BackOfficeController;
import com.deicos.magnolia.spring.service.MyCompanyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * backoffice-magnolia
 * com.deicos.magnolia.spring.rest
 * Created by Alberto Soto Fernandez in 22/05/2017.
 * Description:
 */
@RestController
@RequestMapping("/stats")
public class StatsController extends BackOfficeController {
    @Autowired
    protected MyCompanyDataService dataService;

    @RequestMapping(value = "/salary", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HighChartsWrapper> getStats() {
        try {
            HighChartsWrapper data = dataService.getSalaryStats();
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (Exception e) {
            log.error("register:statistics/", e);
            return new ResponseEntity<>(new HighChartsWrapper(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

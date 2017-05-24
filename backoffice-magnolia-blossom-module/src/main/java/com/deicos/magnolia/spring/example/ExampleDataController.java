package com.deicos.magnolia.spring.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * backoffice-magnolia
 * com.deicos.magnolia.spring.example
 * Created by Alberto Soto Fernandez in 22/05/2017.
 * Description:
 */
@RestController
@RequestMapping("/example")
public class ExampleDataController {

    @Autowired
    protected ExampleDataService dataService;

    @RequestMapping(path = "/list", method = RequestMethod.GET , headers = "Accept=*/*")
    protected ResponseEntity<List<String>> listResponseEntity() {
        //final HttpHeaders httpHeaders= new HttpHeaders();
        //httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        try {
            return new ResponseEntity<>(dataService.getCollection(), /*httpHeaders,*/ HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), /*httpHeaders,*/HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

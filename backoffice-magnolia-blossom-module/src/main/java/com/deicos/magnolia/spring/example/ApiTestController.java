package com.deicos.magnolia.spring.example;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * backoffice-magnolia
 * com.deicos.magnolia.spring
 * Created by Alberto Soto Fernandez in 19/05/2017.
 * Description:
 */
@RestController
@RequestMapping("/dummy1")
public class ApiTestController {

    //works under /api/spring/v1/dummy1/spring returns =>html (¿?)
    @RequestMapping("/rest")
    public String external() {
        return "This is an externally accessible controller";
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public String getGreeting(@PathVariable String name) {
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        String result="Hello "+name;
        return result;
    }

    //works under /api/spring/v1/dummy1/yuhu.json
    @RequestMapping(path = "/yuhu", method = RequestMethod.GET , headers = "Accept=*/*")
    protected ResponseEntity<List<String>> doJSONGet() {
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        try {
            List<String> nodeList = new ArrayList<>();
            nodeList.add("yuhu1");
            return new ResponseEntity<>(nodeList, httpHeaders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), httpHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
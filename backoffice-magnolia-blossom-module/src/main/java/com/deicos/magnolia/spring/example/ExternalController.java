package com.deicos.magnolia.spring.example;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * backoffice-magnolia
 * com.deicos.magnolia.spring
 * Created by Alberto Soto Fernandez in 19/05/2017.
 * Description:
 */
@Controller
public class ExternalController {

    //works under /api/spring/v1/dummy2/dummy
    @RequestMapping("/dummy2/dummy")
    @ResponseBody
    public String external() {
        return "This is an externally accessible controller";
    }

    //works under /api/spring/v1/dummy2/yuhu.json
    @RequestMapping(path = "/dummy2/yuhu", method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=*")
    @ResponseBody
    protected ResponseEntity<List<String>> doJSONGet(HttpServletRequest request, HttpServletResponse response) {
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        try {
            List<String> nodeList = new ArrayList<>();
            nodeList.add("yuhu2");
            return new ResponseEntity<>(nodeList, httpHeaders,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(),httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
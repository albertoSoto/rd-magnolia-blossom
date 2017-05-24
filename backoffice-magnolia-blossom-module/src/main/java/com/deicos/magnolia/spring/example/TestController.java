package com.deicos.magnolia.spring.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * backoffice-magnolia
 * com.deicos.magnolia.spring
 * Created by Alberto Soto Fernandez in 18/05/2017.
 * Description:
 */

@Controller
//@Template(title = "Check External Payment", id = TestController.DEFINITION)
//@TemplateDescription("Dinamic partial component for external payment checking")
@RequestMapping(TestController.RQ_MAPPING_NAME)
public class TestController {
    public static final String DEFINITION = "backoffice-magnolia:components/test";
    public static final String RQ_MAPPING_NAME = "/dummy3";

    /*
        @ResponseBody
        public String render() {
            return "Hello!";
        }

        @RequestMapping(method = RequestMethod.GET,produces="application/json")
        protected @ResponseBody String doJSONGet(BindingResult result, Node node, ModelMap model
                , HttpSession session, HttpServletRequest request, HttpServletResponse response){
            return getResponseAsJson();
        }*/
    @RequestMapping(/*value = "/get", */method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getData() {
        try {
            List<String> nodeList = new ArrayList<>();
            nodeList.add("yuhu");
            return new ResponseEntity<>(nodeList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
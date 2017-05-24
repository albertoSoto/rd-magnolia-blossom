package com.deicos.magnolia.spring.rest;

import com.deicos.magnolia.data.Employee;
import com.deicos.magnolia.data.generic.DataTableWrapper;
import com.deicos.magnolia.spring.generic.BackOfficeController;
import com.deicos.magnolia.spring.service.MyCompanyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * backoffice-magnolia
 * com.deicos.magnolia.spring.rest
 * Created by Alberto Soto Fernandez in 22/05/2017.
 * Description:
 */
@RestController
@RequestMapping("/dt")
public class DataTableController extends BackOfficeController {
    @Autowired
    protected MyCompanyDataService dataService;

    @RequestMapping(path = "/employee", method = RequestMethod.GET , headers = "Accept=*/*")
    public ResponseEntity<DataTableWrapper<Employee>> getActions(HttpServletRequest request, HttpServletResponse response){
        try{
            return new ResponseEntity<>(new DataTableWrapper<>(dataService.getEmployees()), HttpStatus.OK);
            //return getResponse(dataService.getEmployees());
        }catch (Exception e){
            return getErrorResponse(null,e);
        }
    }

}

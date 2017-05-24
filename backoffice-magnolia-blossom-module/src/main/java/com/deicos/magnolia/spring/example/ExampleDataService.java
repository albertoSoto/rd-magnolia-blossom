package com.deicos.magnolia.spring.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * backoffice-magnolia
 * com.deicos.magnolia.spring.service
 * Created by Alberto Soto Fernandez in 22/05/2017.
 * Description:
 */
@Service
public class ExampleDataService {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    private static LinkedList<String> data = new LinkedList<>();

    public List<String> getCollection() {
        if (data.isEmpty()){
            generateDummyData();
        }
        return data;
    }

    private void generateDummyData(){
        if (data.isEmpty()){
            for (int i=0;i<10;i++){
                data.add("dummyData"+i);
            }
        }
    }
}

package com.deicos.magnolia.data;

import org.apache.commons.lang3.StringUtils;

/**
 * backoffice-magnolia
 * com.deicos.magnolia.data
 * Created by Alberto Soto Fernandez in 22/05/2017.
 * Description:
 */
public class WorkerCategory {
    String name;

    public WorkerCategory(){
        this(StringUtils.EMPTY);
    }

    public WorkerCategory(String name){
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

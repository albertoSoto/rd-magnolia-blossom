package com.deicos.magnolia.data.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * backoffice-magnolia
 * com.deicos.magnolia.data
 * Created by Alberto Soto Fernandez in 19/05/2017.
 * Description:
 */
public class HighChartsSerie {
    String name = new String();
    List<Double> data = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getData() {
        return data;
    }

    public void setData(List<Double> data) {
        this.data = data;
    }
}

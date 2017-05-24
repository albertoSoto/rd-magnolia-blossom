package com.deicos.magnolia.data.generic;

import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * backoffice-magnolia
 * com.deicos.magnolia.data
 * Created by Alberto Soto Fernandez in 19/05/2017.
 * Description:
 */
public class HighChartsWrapper {
    List<HighChartsSerie> series = new ArrayList<>();
    List<String> xSeriesLabels = new ArrayList<>();
    List<Pair<Integer, String>> ySeriesLabels = new ArrayList<>();

    public List<HighChartsSerie> getSeries() {
        return series;
    }

    public void setSeries(List<HighChartsSerie> series) {
        this.series = series;
    }

    public List<String> getxSeriesLabels() {
        return xSeriesLabels;
    }

    public void setxSeriesLabels(List<String> xSeriesLabels) {
        this.xSeriesLabels = xSeriesLabels;
    }

    public List<Pair<Integer, String>> getySeriesLabels() {
        return ySeriesLabels;
    }

    public void setySeriesLabels(List<Pair<Integer, String>> ySeriesLabels) {
        this.ySeriesLabels = ySeriesLabels;
    }
}

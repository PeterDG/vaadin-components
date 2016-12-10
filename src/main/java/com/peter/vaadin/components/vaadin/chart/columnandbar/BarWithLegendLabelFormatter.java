package com.peter.vaadin.components.vaadin.chart.columnandbar;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.addon.charts.Chart;
import com.peter.vaadin.components.vaadin.chart.AbstractVaadinChartExample;
import com.peter.vaadin.components.vaadin.chart.SkipFromDemo;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.Legend;
import com.vaadin.addon.charts.model.ListSeries;
import com.vaadin.addon.charts.model.Series;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
@SkipFromDemo
public class BarWithLegendLabelFormatter extends AbstractVaadinChartExample {

    @Override
    public String getDescription() {
        return "Basic bar with legend label formatter";
    }

    @Override
    protected Component getChart() {
        Chart chart = new Chart(ChartType.BAR);

        Configuration conf = chart.getConfiguration();

        conf.setTitle("Historic World Population by Region");
        conf.setSubTitle("Source: Wikipedia.org");

        Legend legend = new Legend();
        legend.setLabelFormatter("function() { return this.name + ' (click to hide)'; }");
        conf.setLegend(legend);

        List<Series> series = new ArrayList<Series>();
        series.add(new ListSeries("Year 1800", 107, 31, 635, 203, 2));
        series.add(new ListSeries("Year 1900", 133, 156, 947, 408, 6));
        series.add(new ListSeries("Year 2008", 973, 914, 4054, 732, 34));
        conf.setSeries(series);

        return chart;
    }
}

package com.peter.vaadin.components.vaadin.chart.lineandscatter;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.peter.vaadin.components.vaadin.chart.AbstractVaadinChartExample;
import com.vaadin.ui.Component;

import java.util.ArrayList;
import java.util.List;

public class UtcTimeDataAndTooltipDateFormat extends AbstractVaadinChartExample {

    public List<DataSeries> dataSeriesList;
    public Configuration configuration;
    public Chart chart;
    public UtcTimeDataAndTooltipDateFormat(List<DataSeries> dataSeriesList) {
        this.dataSeriesList = dataSeriesList;
        chart = new Chart();
        chart.setHeight("450px");
        chart.setWidth("100%");
        configuration = chart.getConfiguration();
        configuration.setTitle("Time and date in tooltip");
        configuration.getChart().setType(ChartType.SPLINE);
        configuration.getxAxis().setType(AxisType.DATETIME);
        // Finnish convention for date formatting
        configuration.getTooltip().setxDateFormat("%d.%m. %Y %H:%M");
    }

    @Override
    public String getDescription() {
        return "Basic Line With Data Labels";
    }

    @Override
    protected Component getChart() {
        setDataSeriesList(dataSeriesList);
        chart.drawChart(configuration);
        return chart;
    }

    public void setTitle(String title){
        configuration.setTitle(title);
        chart.drawChart(configuration);
    }

    public void setDataSeriesList(List<DataSeries> dataSeriesList){
        for(DataSeries series: dataSeriesList){
            configuration.addSeries(series);
        }
    }

    public void update(List<DataSeries> dataSeriesList){
        configuration.setSeries(new ArrayList<Series>());
        setDataSeriesList(dataSeriesList);
        chart.drawChart(configuration);
//        getUI().access(() ->
//                this.dataSeriesList=dataSeriesList);
    }

}

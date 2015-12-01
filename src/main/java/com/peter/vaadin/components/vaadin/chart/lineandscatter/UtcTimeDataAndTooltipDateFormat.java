package com.peter.vaadin.components.vaadin.chart.lineandscatter;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.peter.vaadin.components.vaadin.chart.AbstractVaadinChartExample;
import com.vaadin.ui.Component;

import java.util.List;

public class UtcTimeDataAndTooltipDateFormat extends AbstractVaadinChartExample {

    public List<DataSeries> dataSeriesList;

    public UtcTimeDataAndTooltipDateFormat(List<DataSeries> dataSeriesList) {
        this.dataSeriesList = dataSeriesList;
    }

    @Override
    public String getDescription() {
        return "Basic Line With Data Labels";
    }

    @Override
    protected Component getChart() {
        Chart chart = new Chart();
        chart.setHeight("450px");
        chart.setWidth("100%");

        Configuration configuration = chart.getConfiguration();
        configuration.setTitle("Time and date in tooltip");
        configuration.getChart().setType(ChartType.SPLINE);

        configuration.getxAxis().setType(AxisType.DATETIME);

        // Finnish convention for date formatting
        configuration.getTooltip().setxDateFormat("%d.%m. %Y %H:%M");
        for(DataSeries series: dataSeriesList){
            configuration.addSeries(series);
        }

        chart.drawChart(configuration);
        return chart;
    }

}

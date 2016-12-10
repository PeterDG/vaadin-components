package com.peter.vaadin.components.vaadin.chart.other;

import com.vaadin.addon.charts.Chart;
import com.peter.vaadin.components.vaadin.chart.AbstractVaadinChartExample;
import com.peter.vaadin.components.vaadin.chart.SkipFromDemo;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.ListSeries;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.ui.Component;

@SkipFromDemo
public class BorderColorTest extends AbstractVaadinChartExample {

    @Override
    public String getDescription() {
        return "Test border color and radius.";
    }

    @Override
    protected Component getChart() {
        Chart chart = new Chart(ChartType.BAR);
        chart.setHeight("450px");
        chart.setWidth("100%");

        chart.getConfiguration().addSeries(new ListSeries(1, 2, 3));

        chart.getConfiguration().getChart().setBorderWidth(5);
        chart.getConfiguration().getChart()
                .setBorderColor(new SolidColor("green"));
        chart.getConfiguration().getChart().setBorderRadius(25);

        return chart;
    }

}

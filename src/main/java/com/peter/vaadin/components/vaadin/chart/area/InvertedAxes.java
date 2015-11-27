package com.peter.vaadin.components.vaadin.chart.area;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.peter.vaadin.components.vaadin.chart.AbstractVaadinChartExample;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
public class InvertedAxes extends AbstractVaadinChartExample {

    @Override
    public String getDescription() {
        return "Inverted Axes";
    }

    @Override
    protected Component getChart() {
        Chart chart = new Chart(ChartType.AREA);

        Configuration conf = chart.getConfiguration();

        conf.getChart().setInverted(true);

        conf.setTitle(new Title("Average fruit consumption during one week"));

        XAxis xAxis = new XAxis();
        xAxis.setCategories("Monday", "Tuesday", "Wednesday", "Thursday",
                "Friday", "Saturday", "Sunday");
        conf.addxAxis(xAxis);

        YAxis yAxis = new YAxis();
        yAxis.setTitle(new Title("Number of units"));
        yAxis.setMin(0);
        conf.addyAxis(yAxis);

        Legend legend = new Legend();
        legend.setLayout(LayoutDirection.VERTICAL);
        legend.setHorizontalAlign(HorizontalAlign.LEFT);
        legend.setFloating(true);
        legend.setVerticalAlign(VerticalAlign.TOP);
        legend.setX(-150);
        legend.setY(100);
        legend.setBorderWidth(1);
        legend.setBackgroundColor("#ffffff");
        conf.setLegend(legend);

        PlotOptionsArea plotOptions = new PlotOptionsArea();
        plotOptions.setFillOpacity(0.5);
        conf.setPlotOptions(plotOptions);

        conf.addSeries(new ListSeries("John", 3, 4, 3, 5, 4, 10, 12));
        conf.addSeries(new ListSeries("Jane", 1, 3, 4, 3, 3, 5, 4));

        chart.drawChart(conf);

        return chart;
    }

}

package com.peter.vaadin.components.vaadin.chart.columnandbar;

import com.vaadin.addon.charts.Chart;
import com.peter.vaadin.components.vaadin.chart.AbstractVaadinChartExample;
import com.peter.vaadin.components.vaadin.chart.SkipFromDemo;
import com.vaadin.addon.charts.model.AxisType;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.DataSeries;
import com.vaadin.addon.charts.model.DataSeriesItem;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
@SkipFromDemo
public class ColumnWithIncompleteCategories extends AbstractVaadinChartExample {

    @Override
    public String getDescription() {
        return "Basic column with incomplete series";
    }

    @Override
    protected Component getChart() {
        Chart mychart = new Chart();

        Configuration configuration = mychart.getConfiguration();
        configuration.getChart().setType(ChartType.COLUMN);
        configuration.getxAxis().setType(AxisType.CATEGORY);

        // series have points for different categories, no series is complete
        // (#13050)
        configuration.setSeries(new DataSeries(new DataSeriesItem("X", 6)),
                new DataSeries(new DataSeriesItem("X", 5)), new DataSeries(
                        new DataSeriesItem("Y", 4)), new DataSeries(
                        new DataSeriesItem("X", 3)), new DataSeries(
                        new DataSeriesItem("X", 2)), new DataSeries(
                        new DataSeriesItem("X", 1)));

        return mychart;
    }
}

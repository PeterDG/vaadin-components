package com.peter.vaadin.components.vaadin.chart.other;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.peter.vaadin.components.vaadin.chart.AbstractVaadinChartExample;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
public class PyramidChartExample extends AbstractVaadinChartExample {

    @Override
    public String getDescription() {
        return "Pyramid chart example";
    }

    @Override
    protected Component getChart() {
        DataSeries dataSeries = new DataSeries("Unique users");
        dataSeries.add(new DataSeriesItem("Website visits", 15654));
        dataSeries.add(new DataSeriesItem("Downloads", 4064));
        dataSeries.add(new DataSeriesItem("Requested price list", 1987));
        dataSeries.add(new DataSeriesItem("Invoice sent", 976));
        dataSeries.add(new DataSeriesItem("Finalized", 846));

        Chart chart = new Chart();

        Configuration conf = chart.getConfiguration();

        conf.setTitle("Sales pyramid");
        conf.getLegend().setEnabled(false);

        PlotOptionsPyramid options = new PlotOptionsPyramid();

        options.setWidthAsPercentage(70); // With default (90%), long labels in
        // this example may be cut
        // options.setWidth(400); // in pixels

        Labels dataLabels = new Labels();
        dataLabels.setFormat("<b>{point.name}</b> ({point.y:,.0f})");
        options.setDataLabels(dataLabels);

        dataSeries.setPlotOptions(options);
        conf.addSeries(dataSeries);

        return chart;
    }

}

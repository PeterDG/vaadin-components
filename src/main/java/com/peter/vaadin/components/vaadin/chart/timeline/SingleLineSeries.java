package com.peter.vaadin.components.vaadin.chart.timeline;

import com.vaadin.addon.charts.Chart;
import com.peter.vaadin.components.vaadin.chart.AbstractVaadinChartExample;
import com.peter.vaadin.components.vaadin.chart.timeline.util.StockPrices;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.DataSeries;
import com.vaadin.addon.charts.model.DataSeriesItem;
import com.vaadin.addon.charts.model.RangeSelector;
import com.vaadin.ui.Component;

public class SingleLineSeries extends AbstractVaadinChartExample {

    @Override
    public String getDescription() {
        return "Single line chart with timeline";
    }

    @Override
    protected Component getChart() {
        final Chart chart = new Chart();
        chart.setHeight("450px");
        chart.setWidth("100%");
        chart.setTimeline(true);

        Configuration configuration = chart.getConfiguration();
        configuration.getTitle().setText("AAPL Stock Price");

        DataSeries dataSeries = new DataSeries();
        for(StockPrices.PriceData data : StockPrices.fetchAaplPrice()) {
            DataSeriesItem item = new DataSeriesItem();
            item.setX(data.getDate());
            item.setY(data.getPrice());
            dataSeries.add(item);
        }
        configuration.setSeries(dataSeries);

        RangeSelector rangeSelector = new RangeSelector();
        rangeSelector.setSelected(1);
        configuration.setRangeSelector(rangeSelector);

        chart.drawChart(configuration);

        return chart;
    }
}

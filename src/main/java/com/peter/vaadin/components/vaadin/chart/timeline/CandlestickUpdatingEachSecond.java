package com.peter.vaadin.components.vaadin.chart.timeline;

import com.peter.vaadin.components.vaadin.chart.AbstractVaadinChartExample;
import com.peter.vaadin.components.vaadin.chart.timeline.util.StockPrices;
import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.ui.Component;

import java.util.Random;

public class CandlestickUpdatingEachSecond extends AbstractVaadinChartExample {

    @Override
    public String getDescription() {
        return "Single line chart with timeline";
    }

    @Override
    protected Component getChart() {
        final Random random = new Random();
        final Chart chart = new Chart(ChartType.CANDLESTICK);
        chart.setHeight("450px");
        chart.setWidth("100%");
        chart.setTimeline(true);

        Configuration configuration = chart.getConfiguration();
        configuration.getTitle().setText("AAPL Stock Price");

        DataSeries dataSeries = new DataSeries();
        PlotOptionsCandlestick plotOptionsCandlestick = new PlotOptionsCandlestick();
        DataGrouping grouping = new DataGrouping();
        grouping.addUnit(new TimeUnitMultiples(TimeUnit.WEEK, 1));
        grouping.addUnit(new TimeUnitMultiples(TimeUnit.MONTH, 1, 2, 3, 4, 6));
        plotOptionsCandlestick.setDataGrouping(grouping);
        dataSeries.setPlotOptions(plotOptionsCandlestick);
        for (StockPrices.OhlcData data : StockPrices.fetchAaplOhlcPrice()) {
            OhlcItem item = new OhlcItem();
            item.setX(data.getDate());
            item.setLow(data.getLow());
            item.setHigh(data.getHigh());
            item.setClose(data.getClose());
            item.setOpen(data.getOpen());
            dataSeries.add(item);
        }

        runWhileAttached(chart, new Runnable() {

            @Override
            public void run() {
                OhlcItem item = new OhlcItem();
                item.setX(System.currentTimeMillis());
                item.setLow(random.nextDouble());
                item.setHigh(random.nextDouble());
                item.setClose(random.nextDouble());
                item.setOpen(random.nextDouble());
                dataSeries.add(item, true, true);
            }
        }, 1000, 1000);

        configuration.setSeries(dataSeries);

        RangeSelector rangeSelector = new RangeSelector();
        rangeSelector.setSelected(4);
        configuration.setRangeSelector(rangeSelector);

        chart.drawChart(configuration);

        return chart;
    }
}

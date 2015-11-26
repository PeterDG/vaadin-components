package org.peter.vaadin.component.chart.lineandscatter;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import org.peter.vaadin.component.chart.AbstractVaadinChartExample;
import com.vaadin.ui.Component;

import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

public class UtcTimeDataAndTooltipDateFormat extends AbstractVaadinChartExample {

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

        // This test uses UTC time stamps, this way chart is independent about
        // execution environment, unlike when using Date
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Calendar c = Calendar.getInstance(timeZone);
        c.set(Calendar.MILLISECOND, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.HOUR_OF_DAY, 12);
        c.set(2013, 2, 11);

        DataSeries dataSeries = new DataSeries();
        Number[] values = new Number[] { 29.9, 71.5, 106.4, 129.2, 144.0,
                176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4 };
        Random r = new Random(0);
        for (Number number : values) {
            c.add(Calendar.MINUTE, r.nextInt(30));
            DataSeriesItem item = new DataSeriesItem(c.getTimeInMillis(),
                    number);
            dataSeries.add(item);
        }

        configuration.addSeries(dataSeries);

        chart.drawChart(configuration);
        return chart;
    }

}

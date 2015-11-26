package org.peter.vaadin.component.chart.area;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import org.peter.vaadin.component.chart.AbstractVaadinChartExample;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
public class PercentageArea extends AbstractVaadinChartExample {

    @Override
    public String getDescription() {
        return "Percentage area";
    }

    @Override
    protected Component getChart() {
        Component chart = createNewChart();
        return chart;
    }

    public static Chart createNewChart() {

        Chart chart = new Chart(ChartType.AREA);

        Configuration conf = chart.getConfiguration();

        conf.setTitle(new Title(
                "Historic and Estimated Worldwide Population Distribution by Region"));
        conf.setSubTitle(new SubTitle("Source: Wikipedia.org"));

        XAxis xAxis = new XAxis();
        xAxis.setTickmarkPlacement(TickmarkPlacement.ON);
        xAxis.setCategories("1750", "1800", "1850", "1900", "1950", "1999",
                "2050");
        conf.addxAxis(xAxis);

        YAxis yAxis = new YAxis();
        yAxis.setTitle(new Title("Percent"));
        conf.addyAxis(yAxis);

        Tooltip tooltip = new Tooltip();
        tooltip.setFormatter("this.series.name + ': ' +this.x +': '+ Highcharts.numberFormat(this.percentage, 1) +'% ('+ Highcharts.numberFormat(this.y, 0, ',') +' millions)'");
        conf.setTooltip(tooltip);

        PlotOptionsArea plotOptions = new PlotOptionsArea();
        plotOptions.setStacking(Stacking.PERCENT);
        plotOptions.setLineWidth(1);
        Marker marker = new Marker();
        plotOptions.setMarker(marker);
        conf.setPlotOptions(plotOptions);

        conf.addSeries(new ListSeries("Asia", 502, 635, 809, 947, 1402, 3634,
                5268));
        conf.addSeries(new ListSeries("Africa", 106, 107, 111, 133, 221, 767,
                1766));
        conf.addSeries(new ListSeries("Europe", 163, 203, 276, 408, 547, 729,
                628));
        conf.addSeries(new ListSeries("America", 18, 31, 54, 156, 339, 818,
                1201));
        conf.addSeries(new ListSeries("Ocenia", 2, 2, 2, 6, 13, 30, 46));

        chart.drawChart(conf);

        return chart;
    }
}

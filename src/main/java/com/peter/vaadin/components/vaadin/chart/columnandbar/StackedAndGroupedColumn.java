package com.peter.vaadin.components.vaadin.chart.columnandbar;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.peter.vaadin.components.vaadin.chart.AbstractVaadinChartExample;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
public class StackedAndGroupedColumn extends AbstractVaadinChartExample {

    @Override
    public String getDescription() {
        return "Stacked and Grouped Column";
    }

    @Override
    protected Component getChart() {
        Chart chart = new Chart(ChartType.COLUMN);

        Configuration conf = chart.getConfiguration();

        conf.setTitle(new Title("Total fruit consumption, grouped by gender"));

        XAxis xAxis = new XAxis();
        xAxis.setCategories(new String[] { "Apples", "Oranges", "Pears",
                "Grapes", "Bananas" });
        conf.addxAxis(xAxis);

        YAxis yAxis = new YAxis();
        yAxis.setAllowDecimals(false);
        yAxis.setMin(0);
        yAxis.setTitle(new Title("Number of fruits"));
        conf.addyAxis(yAxis);

        Tooltip tooltip = new Tooltip();
        tooltip.setFormatter("function() { return '<b>'+ this.x +'</b><br/>'"
                + "+this.series.name +': '+ this.y +'<br/>'+'Total: '+ this.point.stackTotal; }");
        conf.setTooltip(tooltip);

        PlotOptionsColumn plotOptions = new PlotOptionsColumn();
        plotOptions.setStacking(Stacking.NORMAL);
        conf.setPlotOptions(plotOptions);

        ListSeries serie = new ListSeries("John",
                new Number[] { 5, 3, 4, 7, 2 });
        serie.setStack("male");
        conf.addSeries(serie);

        serie = new ListSeries("Joe", new Number[] { 3, 4, 4, 2, 5 });
        serie.setStack("male");
        conf.addSeries(serie);

        serie = new ListSeries("Jane", new Number[] { 2, 5, 6, 2, 1 });
        serie.setStack("female");
        conf.addSeries(serie);

        serie = new ListSeries("Janet", new Number[] { 3, 0, 4, 4, 3 });
        serie.setStack("female");
        conf.addSeries(serie);

        chart.drawChart(conf);

        return chart;
    }

}

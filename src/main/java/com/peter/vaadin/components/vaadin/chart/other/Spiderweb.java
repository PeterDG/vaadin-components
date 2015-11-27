package com.peter.vaadin.components.vaadin.chart.other;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.peter.vaadin.components.vaadin.chart.AbstractVaadinChartExample;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
public class Spiderweb extends AbstractVaadinChartExample {

    @Override
    public String getDescription() {
        return "Spiderweb";
    }

    @Override
    protected Component getChart() {
        Chart chart = new Chart(ChartType.LINE);

        Configuration conf = chart.getConfiguration();
        conf.getChart().setPolar(true);
        conf.setTitle("Budget vs spending");
        conf.getTitle().setX(-80);

        Pane pane = new Pane();
        pane.setSize("80%");
        conf.addPane(pane);
        pane.setBackground(new Background[] {});

        XAxis axis = new XAxis();
        axis.setCategories("Sales", "Marketing", "Development",
                "Customer Support", "Information Technology", "Administration");
        axis.setTickmarkPlacement(TickmarkPlacement.ON);
        axis.setLineWidth(0);

        YAxis yaxs = new YAxis();
        yaxs.setGridLineInterpolation("polygon");
        yaxs.setMin(0);
        yaxs.setLineWidth(0);
        conf.addxAxis(axis);
        conf.addyAxis(yaxs);

        conf.getTooltip().setShared(true);
        conf.getTooltip().setValuePrefix("$");

        conf.getLegend().setHorizontalAlign(HorizontalAlign.RIGHT);
        conf.getLegend().setVerticalAlign(VerticalAlign.TOP);
        conf.getLegend().setY(100);
        conf.getLegend().setLayout(LayoutDirection.VERTICAL);

        ListSeries line1 = new ListSeries(43000, 19000, 60000, 35000, 17000,
                10000);
        ListSeries line2 = new ListSeries(50000, 39000, 42000, 31000, 26000,
                14000);
        PlotOptionsLine plotOptions = new PlotOptionsLine();
        plotOptions.setPointPlacement(PointPlacement.ON);
        line1.setPlotOptions(plotOptions);
        line1.setName("Allocated Budget");

        plotOptions = new PlotOptionsLine();
        plotOptions.setPointPlacement(PointPlacement.ON);
        line2.setPlotOptions(plotOptions);
        line2.setName("Actual Spending");

        conf.setSeries(line1, line2);

        chart.drawChart(conf);

        return chart;
    }
}

package com.peter.vaadin.components.vaadin.chart.other;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.peter.vaadin.components.vaadin.chart.AbstractVaadinChartExample;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
public class WindRose extends AbstractVaadinChartExample {

    @Override
    public String getDescription() {
        return "Windrose";
    }

    @Override
    protected Component getChart() {
        Chart chart = new Chart(ChartType.COLUMN);

        Configuration conf = chart.getConfiguration();
        conf.getChart().setPolar(true);
        conf.getChart().setInverted(false);
        conf.setTitle("Wind rose for South Shore Met Station, Oregon");
        conf.setSubTitle("Source: or.water.usgs.gov");

        Pane pane = new Pane();
        pane.setSize("85%");
        conf.addPane(pane);
        pane.setBackground(new Background[] {});

        conf.getLegend().setReversed(false);
        conf.getLegend().setHorizontalAlign(HorizontalAlign.RIGHT);
        conf.getLegend().setVerticalAlign(VerticalAlign.TOP);
        conf.getLegend().setY(100);
        conf.getLegend().setLayout(LayoutDirection.VERTICAL);

        XAxis axis = new XAxis();
        axis.setCategories("< 0.5 m/s", "0.5-2 m/s", "2-4 m/s", "4-6 m/s",
                "6-8 m/s", "8-10 m/s", "> 10 m/s");
        axis.setTickmarkPlacement(TickmarkPlacement.ON);

        YAxis yaxs = new YAxis();
        yaxs.setMin(0);
        yaxs.setEndOnTick(false);
        yaxs.setShowLastLabel(true);
        yaxs.setTitle("Frequency (%)");
        yaxs.getLabels().setFormatter("function() {return this.value + '%';}");
        conf.addxAxis(axis);
        conf.addyAxis(yaxs);

        conf.getTooltip().setValueSuffix("%");

        PlotOptionsSeries series = new PlotOptionsSeries();
        series.setStacking(Stacking.NORMAL);
        series.setShadow(false);
        series.setGroupPadding(0);
        series.setPointPlacement(PointPlacement.ON);
        conf.setPlotOptions(series);

        ListSeries n = new ListSeries("N", 1.81, 1.78, 0.16, 0.00, 0.00, 0.00,
                0.00);
        ListSeries nne = new ListSeries("NNE", 0.62, 1.09, 0.00, 0.00, 0.00,
                0.00, 0.00);
        ListSeries ne = new ListSeries("NE", 0.82, 0.82, 0.07, 0.00, 0.00,
                0.00, 0.00);
        ListSeries ene = new ListSeries("ENE", 0.59, 1.22, 0.07, 0.00, 0.00,
                0.00, 0.00);
        ListSeries e = new ListSeries("E", 0.62, 2.20, 0.49, 0.00, 0.00, 0.00,
                0.00);
        ListSeries ese = new ListSeries("ESE", 1.22, 2.01, 1.55, 0.30, 0.13,
                0.00, 0.00);
        ListSeries se = new ListSeries("SE", 1.61, 3.06, 2.37, 2.14, 1.74,
                0.39, 0.13);
        ListSeries sse = new ListSeries("SSE", 2.04, 3.42, 1.97, 0.86, 0.53,
                0.49, 0.00);
        ListSeries s = new ListSeries("S", 2.66, 4.74, 0.43, 0.00, 0.00, 0.00,
                0.00);
        ListSeries ssw = new ListSeries("SSW", 2.96, 4.14, 0.26, 0.00, 0.00,
                0.00, 0.00);
        ListSeries sw = new ListSeries("SW", 2.53, 4.01, 1.22, 0.49, 0.13,
                0.00, 0.00);
        ListSeries wsw = new ListSeries("WSW", 1.97, 2.66, 1.97, 0.79, 0.30,
                0.00, 0.00);
        ListSeries w = new ListSeries("W", 1.64, 1.71, 0.92, 1.45, 0.26, 0.10,
                0.00);
        ListSeries wnw = new ListSeries("WNW", 1.32, 2.40, 0.99, 1.61, 0.33,
                0.00, 0.00);
        ListSeries nw = new ListSeries("NW", 1.58, 4.28, 1.28, 0.76, 0.66,
                0.69, 0.03);
        ListSeries nnw = new ListSeries("NNW", 1.51, 5.00, 1.32, 0.13, 0.23,
                0.13, 0.07);

        conf.setSeries(n, nne, ne, ene, e, ese, se, sse, s, ssw, sw, wsw, w,
                wnw, nw, nnw);
        // transpose data "matrix"
        conf.reverseListSeries();

        chart.drawChart(conf);

        return chart;
    }
}

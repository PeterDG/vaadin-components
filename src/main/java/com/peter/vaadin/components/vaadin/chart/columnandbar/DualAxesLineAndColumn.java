package com.peter.vaadin.components.vaadin.chart.columnandbar;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.addon.charts.model.style.Style;
import com.peter.vaadin.components.vaadin.chart.AbstractVaadinChartExample;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
public class DualAxesLineAndColumn extends AbstractVaadinChartExample {

    @Override
    public String getDescription() {
        return "Dual axes, line and column";
    }

    @Override
    protected Component getChart() {
        Chart chart = new Chart();

        Configuration conf = chart.getConfiguration();

        conf.getChart().setZoomType(ZoomType.XY);

        conf.setTitle("Average Monthly Temperature and Rainfall in Tokyo");
        conf.setSubTitle("Source: WorldClimate.com");

        XAxis x = new XAxis();
        x.setCategories("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec");
        conf.addxAxis(x);

        YAxis primary = new YAxis();
        primary.setTitle("Temperature");
        Style style = new Style();
        style.setColor(getThemeColors()[1]);
        primary.getTitle().setStyle(style);
        conf.addyAxis(primary);

        YAxis snd = new YAxis();
        snd.setTitle("Rainfall");
        snd.setOpposite(true);
        style = new Style();
        style.setColor(new SolidColor("#4572A7"));
        snd.getTitle().setStyle(style);
        conf.addyAxis(snd);

        Tooltip tooltip = new Tooltip();
        tooltip.setFormatter("this.x +': '+ this.y + (this.series.name == 'Rainfall' ? ' mm' : '°C')");
        conf.setTooltip(tooltip);

        Legend legend = new Legend();
        legend.setLayout(LayoutDirection.VERTICAL);
        legend.setHorizontalAlign(HorizontalAlign.LEFT);
        legend.setX(120);
        legend.setVerticalAlign(VerticalAlign.TOP);
        legend.setY(100);
        legend.setFloating(true);
        conf.setLegend(legend);

        DataSeries series = new DataSeries();
        series.setPlotOptions(new PlotOptionsColumn());
        series.setName("Rainfall");
        series.setData(49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5,
                216.4, 194.1, 95.6, 54.4);
        series.setyAxis(1);
        conf.addSeries(series);

        series = new DataSeries();
        PlotOptionsSpline plotOptions = new PlotOptionsSpline();
        series.setPlotOptions(plotOptions);
        series.setName("Temperature");
        series.setData(7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3,
                13.9, 9.6);
        plotOptions.setColor(getThemeColors()[1]);
        conf.addSeries(series);

        return chart;
    }
}

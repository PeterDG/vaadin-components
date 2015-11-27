package com.peter.vaadin.components.vaadin.chart.columnandbar;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.ui.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 4/3/2015.
 */

@SuppressWarnings("serial")
public class BasicBar extends Chart {


    public BasicBar() {
      getChart();
    }

    public String getDescription() {
        return "Basic bar";
    }


    protected Component getChart() {

        getConfiguration().getChart().setType(ChartType.BAR);
        Configuration conf = getConfiguration();

        conf.setTitle("Historic World Population by Region");
        conf.setSubTitle("Source: Wikipedia.org");

        XAxis x = new XAxis();
        x.setCategories("Africa", "America", "Asia", "Europe", "Oceania");
        x.setTitle((String) null);
        conf.addxAxis(x);

        YAxis y = new YAxis();
        y.setMin(0);
        Title title = new Title("Population (millions)");
        title.setVerticalAlign(VerticalAlign.HIGH);
        y.setTitle(title);
        conf.addyAxis(y);

        Tooltip tooltip = new Tooltip();
        tooltip.setFormatter("this.series.name +': '+ this.y +' millions'");
        conf.setTooltip(tooltip);

        PlotOptionsBar plot = new PlotOptionsBar();
        plot.setDataLabels(new Labels(true));
        conf.setPlotOptions(plot);

        Legend legend = new Legend();
        legend.setLayout(LayoutDirection.VERTICAL);
        legend.setHorizontalAlign(HorizontalAlign.RIGHT);
        legend.setVerticalAlign(VerticalAlign.TOP);
        legend.setX(-100);
        legend.setY(100);
        legend.setFloating(true);
        legend.setBorderWidth(1);
        legend.setBackgroundColor("#FFFFFF");
        legend.setShadow(true);
        conf.setLegend(legend);

        conf.disableCredits();

        List series = new ArrayList();
        series.add(new ListSeries("Year 1800", 107, 31, 635, 203, 2));
        series.add(new ListSeries("Year 1900", 133, 156, 947, 408, 6));
        series.add(new ListSeries("Year 2008", 973, 914, 4054, 732, 34));
        conf.setSeries(series);

        drawChart(conf);

        return this;
    }
}
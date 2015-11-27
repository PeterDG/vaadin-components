package com.peter.vaadin.components.vaadin.chart.threed;

/**
 * Created by Peter on 4/3/2015.
 */

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.PointClickEvent;
import com.vaadin.addon.charts.PointClickListener;
import com.vaadin.addon.charts.model.*;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;

@SuppressWarnings("serial")
public class Basic3DPie extends Chart {

    public Basic3DPie() {
        getChart();
    }

    @Override
    public String getDescription() {
        return "3D Pie chart";
    }


    protected Component getChart() {
        Component ret = createChart();
        ret.setWidth("100%");
        ret.setHeight("450px");
        return ret;
    }

    public Chart createChart() {


        Configuration conf = this.getConfiguration();
        conf.getChart().setType(ChartType.PIE);
        conf.setTitle("Browser market shares at a specific website, 2010");

        PlotOptionsPie plotOptions = new PlotOptionsPie();
        plotOptions.setCursor(Cursor.POINTER);
        Labels dataLabels = new Labels(true);
        dataLabels
                .setFormatter("''+ this.point.name +': '+ this.percentage +' %'");
        plotOptions.setDataLabels(dataLabels);

        plotOptions.setDepth(45);

        conf.setPlotOptions(plotOptions);

        final DataSeries series = new DataSeries();
        series.add(new DataSeriesItem("Firefox", 45.0));
        series.add(new DataSeriesItem("IE", 26.8));
        DataSeriesItem chrome = new DataSeriesItem("Chrome", 12.8);
        chrome.setSliced(true);
        chrome.setSelected(true);
        series.add(chrome);
        series.add(new DataSeriesItem("Safari", 8.5));
        series.add(new DataSeriesItem("Opera", 6.2));
        series.add(new DataSeriesItem("Others", 0.7));
        conf.setSeries(series);

        Options3d options3d = new Options3d();
        options3d.setEnabled(true);
        options3d.setAlpha(60);
        conf.getChart().setOptions3d(options3d);

        this.addPointClickListener(new PointClickListener() {

            @Override
            public void onClick(PointClickEvent event) {
                Notification.show("Click: "
                        + series.get(event.getPointIndex()).getName());
            }
        });

        this.drawChart(conf);

        return this;
    }

}
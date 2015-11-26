package org.peter.vaadin.component.chart.threed;

/**
 * Created by Peter on 4/3/2015.
 */

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
public class Basic3DColumn extends Chart {

    public Basic3DColumn() {
        getChart();
    }

    @Override
    public String getDescription() {
        return "Basic 3d columns";
    }


    protected Component getChart() {
        setCaption("Eficiencia del uso del espacio ");
        getConfiguration().setTitle("");
        Configuration conf = getConfiguration();
        conf.getChart().setType(ChartType.COLUMN);
//        conf.setTitle("Monthly Average Rainfall");
//        conf.setSubTitle("Source: WorldClimate.com");

        XAxis x = new XAxis();
        x.setCategories("2014-II", "2015-I", "2015-II", "2016-I");
        conf.addxAxis(x);

        YAxis y = new YAxis();
        y.setMin(0);
        y.setTitle("Horas (h)");
        conf.addyAxis(y);

        Tooltip tooltip = new Tooltip();
        tooltip.setFormatter("this.x +': '+ this.y +' h'");
        conf.setTooltip(tooltip);

        PlotOptionsColumn plot = new PlotOptionsColumn();
        plot.setPointPadding(0.2);
        plot.setBorderWidth(0);
        plot.setGroupZPadding(10);
        conf.setPlotOptions(plot);

        Options3d options3d = new Options3d();
        options3d.setEnabled(true);
        options3d.setAlpha(5);
        options3d.setBeta(30);
        options3d.setDepth(100);
        options3d.setViewDistance(200);
        Frame frame = new Frame();
        options3d.setFrame(frame);
        conf.getChart().setOptions3d(options3d);

        conf.addSeries(new ListSeries("Tokyo", 49.9, 71.5, 106.4, 129.2));
        conf.addSeries(new ListSeries("New York", 83.6, 78.8, 98.5, 93.4));
        conf.addSeries(new ListSeries("London", 48.9, 38.8, 39.3, 41.4));
        conf.addSeries(new ListSeries("Berlin", 42.4, 33.2, 34.5, 39.7));

        drawChart(conf);
        return this;

    }
}
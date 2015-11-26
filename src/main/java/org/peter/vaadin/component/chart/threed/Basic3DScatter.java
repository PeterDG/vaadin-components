package org.peter.vaadin.component.chart.threed;

/**
 * Created by Peter on 4/3/2015.
 */

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.ChartOptions;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.addon.charts.model.style.Theme;
import com.vaadin.addon.charts.themes.ValoLightTheme;
import com.vaadin.ui.Component;

import java.util.Random;

public class Basic3DScatter extends Chart {

    public Basic3DScatter() {
        getChart();
    }

    @Override
    public String getDescription() {
        return "3D Scatter";
    }


    protected Component getChart() {

        return createScatterChart();

    }

    private Chart createScatterChart() {

        Configuration conf = this.getConfiguration();
        conf.getChart().setType(ChartType.SCATTER);
        this.setId("chart");
        conf.disableCredits();
        conf.setTitle("Points of a sphere");
        PlotOptionsScatter scatterOptions = new PlotOptionsScatter();
        scatterOptions.setAnimation(false);
        scatterOptions.setPointStart(1);

        DataSeries higherX = new DataSeries();
        higherX.setName("Higher X");
        DataSeries higherY = new DataSeries();
        higherY.setName("Higher Y");
        DataSeries higherZ = new DataSeries();
        higherZ.setName("Higher Z");

        fillSeries(higherX, higherY, higherZ);

        conf.addSeries(higherX);
        conf.addSeries(higherY);
        conf.addSeries(higherZ);

        XAxis x = conf.getxAxis();
        x.setGridLineWidth(1);
        x.setExtremes(-3, 3);

        if (getCurrentTheme().getxAxis().getGridLineColor() != null) {
            x.setGridLineColor((SolidColor) getCurrentTheme().getxAxis()
                    .getGridLineColor());
        }

        YAxis y = conf.getyAxis();
        y.setExtremes(-1, 1);

        Options3d options3d = new Options3d();
        options3d.setEnabled(true);
        options3d.setAlpha(10);
        options3d.setBeta(30);
        options3d.setDepth(80);
        options3d.setViewDistance(40);

        Frame frame = new Frame();
        frame.setBottom(new FramePanel(null, 1));
        options3d.setFrame(frame);
        conf.getChart().setOptions3d(options3d);

        this.drawChart();
        return this;

    }

    private void fillSeries(DataSeries higherX, DataSeries higherY,
                            DataSeries higherZ) {
        Random random = new Random(7);
        for (int i = 0; i < 300; i++) {
            double lng = random.nextDouble() * 2 * Math.PI;
            double lat = random.nextDouble() * Math.PI - Math.PI / 2;
            double x = Math.cos(lat) * Math.sin(lng);
            double y = Math.sin(lat);
            double z = Math.cos(lng) * Math.cos(lat);

            DataSeriesItem3d point = new DataSeriesItem3d(x, y, z);
            if (x > y && x > z) {
                higherX.add(point);
            } else if (y > x && y > z) {
                higherY.add(point);
            } else {
                higherZ.add(point);
            }
        }

    }

    protected Theme getCurrentTheme() {
        Theme theme = ChartOptions.get().getTheme();
        return (theme != null) ? theme : new ValoLightTheme();
    }

}
package org.peter.vaadin.component.chart.other;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import org.peter.vaadin.component.chart.AbstractVaadinChartExample;
import org.peter.vaadin.component.chart.SkipFromDemo;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
@SkipFromDemo
public class BubbleChartMaxSizePercentage extends AbstractVaadinChartExample {

    @Override
    public String getDescription() {
        return "Bubble Chart max size as percentage example";
    }

    @Override
    protected Component getChart() {
        Chart chart = new Chart(ChartType.BUBBLE);

        Configuration conf = chart.getConfiguration();
        conf.setTitle((String) null);

        DataSeries dataSeries = new DataSeries();
        dataSeries.add(item(9, 81, 13));
        dataSeries.add(item(98, 5, 39));
        dataSeries.add(item(51, 50, 23));
        dataSeries.add(item(41, 22, -36));
        dataSeries.add(item(58, 24, -30));
        dataSeries.add(item(78, 37, -16));
        dataSeries.add(item(55, 56, 3));
        dataSeries.add(item(18, 45, 20));
        dataSeries.add(item(42, 44, -22));
        dataSeries.add(item(3, 52, 9));
        dataSeries.add(item(31, 50, 47));
        dataSeries.add(item(79, 91, 13));
        dataSeries.add(item(93, 23, -27));
        dataSeries.add(item(44, 83, -28));

        PlotOptionsBubble opts = new PlotOptionsBubble();
        opts.setNegativeColor(getThemeColors()[3]);
        opts.setMaxSizeAsPercentage(50);
        opts.setMinSize(3);

        conf.setPlotOptions(opts);

        conf.addSeries(dataSeries);

        return chart;
    }

    public DataSeriesItem item(int x, int y, int z) {
        DataSeriesItem3d dataSeriesItem = new DataSeriesItem3d();
        dataSeriesItem.setX(x);
        dataSeriesItem.setY(y);
        dataSeriesItem.setZ(z);
        return dataSeriesItem;
    }

}

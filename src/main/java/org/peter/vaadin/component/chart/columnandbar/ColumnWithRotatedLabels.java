package org.peter.vaadin.component.chart.columnandbar;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.addon.charts.model.style.Style;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
public class ColumnWithRotatedLabels extends  Chart {

    public ColumnWithRotatedLabels() {
        getChart();
    }

    @Override
    public String getDescription() {
        return "Column with rotated labels";
    }


    protected Component getChart() {


        Configuration conf = this.getConfiguration();
        conf.getChart().setMargin(50, 80, 100, 50);
        conf.getChart().setType(ChartType.COLUMN);
        conf.setTitle(new Title("World's largest cities per 2008"));

        XAxis xAxis = new XAxis();
        xAxis.setCategories(new String[] { "Tokyo", "Jakarta", "New York",
                "Seoul", "Manila", "Mumbai", "Sao Paulo", "Mexico City",
                "Dehli", "Osaka", "Cairo", "Kolkata", "Los Angeles",
                "Shanghai", "Moscow", "Beijing", "Buenos Aires", "Guangzhou",
                "Shenzhen", "Istanbul" });
        Labels labels = new Labels();
        labels.setRotation(-45);
        labels.setAlign(HorizontalAlign.RIGHT);
        Style style = new Style();
        style.setFontSize("13px");
        style.setFontFamily("Verdana, sans-serif");
        labels.setStyle(style);
        xAxis.setLabels(labels);
        conf.addxAxis(xAxis);

        YAxis yAxis = new YAxis();
        yAxis.setMin(0);
        yAxis.setTitle(new Title("Population (millions)"));
        conf.addyAxis(yAxis);

        Legend legend = new Legend();
        legend.setEnabled(false);
        conf.setLegend(legend);

        Tooltip tooltip = new Tooltip();
        tooltip.setFormatter("'<b>'+ this.x +'</b><br/>'+'Population in 2008: '"
                + "+ Highcharts.numberFormat(this.y, 1) +' millions'");
        conf.setTooltip(tooltip);

        ListSeries serie = new ListSeries("Population", new Number[] { 34.4,
                21.8, 20.1, 20, 19.6, 19.5, 19.1, 18.4, 18, 17.3, 16.8, 15,
                14.7, 14.5, 13.3, 12.8, 12.4, 11.8, 11.7, 11.2 });
        Labels dataLabels = new Labels();
        dataLabels.setEnabled(true);
        dataLabels.setRotation(-90);
        dataLabels.setColor(new SolidColor(255, 255, 255));
        dataLabels.setAlign(HorizontalAlign.RIGHT);
        dataLabels.setX(4);
        dataLabels.setY(10);
        dataLabels.setFormatter("this.y");
        PlotOptionsColumn plotOptionsColumn = new PlotOptionsColumn();
        plotOptionsColumn.setDataLabels(dataLabels);
        serie.setPlotOptions(plotOptionsColumn);
        conf.addSeries(serie);

        this.drawChart(conf);

        return this;
    }
}

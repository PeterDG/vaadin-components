package org.peter.vaadin.component.chart.columnandbar;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.FontWeight;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.addon.charts.model.style.Style;
import org.peter.vaadin.component.chart.AbstractVaadinChartExample;
import org.peter.vaadin.component.chart.SkipFromDemo;
import com.vaadin.ui.Component;

@SkipFromDemo
public class OverrideStackingForSpecificSeries extends
        AbstractVaadinChartExample {

    @Override
    protected Component getChart() {
        Chart chart = new Chart(ChartType.COLUMN);

        Configuration conf = chart.getConfiguration();

        conf.setTitle(new Title("Stacked column chart"));

        XAxis xAxis = new XAxis();
        xAxis.setCategories(new String[] { "Apples", "Oranges", "Pears",
                "Grapes", "Bananas" });
        conf.addxAxis(xAxis);

        YAxis yAxis = new YAxis();
        yAxis.setMin(0);
        yAxis.setTitle(new Title("Total fruit consumption"));
        StackLabels sLabels = new StackLabels(true);
        Style slStyle = new Style();
        slStyle.setFontWeight(FontWeight.BOLD);
        slStyle.setColor(new SolidColor("gray"));
        sLabels.setStyle(slStyle);
        yAxis.setStackLabels(sLabels);
        conf.addyAxis(yAxis);

        Tooltip tooltip = new Tooltip();
        tooltip.setFormatter("'<b>'+ this.x +'</b><br/>'+this.series.name +': '"
                + "+ this.y +'<br/>'+'Total: '+ this.point.stackTotal");
        conf.setTooltip(tooltip);

        PlotOptionsColumn plotOptions = new PlotOptionsColumn();
        plotOptions.setStacking(Stacking.NORMAL);
        Labels labels = new Labels();
        labels.setEnabled(true);
        labels.setColor(new SolidColor("white"));
        plotOptions.setDataLabels(labels);
        conf.setPlotOptions(plotOptions);

        conf.addSeries(new ListSeries("John", new Number[] { 5, 3, 4, 7, 2 }));
        conf.addSeries(new ListSeries("Jane", new Number[] { 2, 2, 3, 2, 1 }));

        ListSeries series = new ListSeries("Joe",
                new Number[] { 3, 4, 4, 2, 5 });
        PlotOptionsColumn joePlotOptions = new PlotOptionsColumn();
        joePlotOptions.setStacking(Stacking.NONE);
        series.setPlotOptions(joePlotOptions);
        conf.addSeries(series);

        chart.drawChart(conf);
        return chart;
    }

}
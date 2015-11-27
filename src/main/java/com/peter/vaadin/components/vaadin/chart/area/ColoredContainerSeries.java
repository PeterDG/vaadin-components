package com.peter.vaadin.components.vaadin.chart.area;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.data.util.BeanItemContainer;
import com.peter.vaadin.components.vaadin.chart.AbstractVaadinChartExample;
import com.peter.vaadin.components.vaadin.chart.SkipFromDemo;
import com.vaadin.ui.Component;

@SkipFromDemo
public class ColoredContainerSeries extends AbstractVaadinChartExample {

    protected class Test {
        private int number;
        private String name;

        public Test(final int number, final String name) {
            this.number = number;
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public String getName() {
            return name;
        }
    }

    protected Component getChart() {
        Chart chart = new Chart(ChartType.AREA);

        Configuration conf = chart.getConfiguration();

        conf.setTitle(new Title("Colored ContainerDataSeries"));

        conf.addxAxis(new XAxis());
        YAxis yAxis = new YAxis();
        yAxis.setTitle("Numbers");
        conf.addyAxis(yAxis);

        BeanItemContainer<Test> beanItemContainer = new BeanItemContainer<Test>(
                Test.class);
        beanItemContainer.addBean(new Test(10, "TEN"));
        beanItemContainer.addBean(new Test(11, "ELEVEN"));
        beanItemContainer.addBean(new Test(12, "TWELVE"));

        ContainerDataSeries containerDataSeries = new ContainerDataSeries(
                beanItemContainer);
        containerDataSeries.setName("Test Series");
        containerDataSeries.setYPropertyId("number");
        containerDataSeries.setNamePropertyId("name");

        PlotOptionsArea plotOptions = new PlotOptionsArea();
        plotOptions.setFillColor(SolidColor.CORNFLOWERBLUE);
        plotOptions.setColor(SolidColor.GOLDENROD);
        containerDataSeries.setPlotOptions(plotOptions);

        // conf.setPlotOptions(plotOptions);

        conf.setSeries(containerDataSeries);

        chart.drawChart(conf);

        return chart;
    }
}

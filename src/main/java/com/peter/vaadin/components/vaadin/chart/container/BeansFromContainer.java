package com.peter.vaadin.components.vaadin.chart.container;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.data.util.BeanItemContainer;
import com.peter.vaadin.components.vaadin.chart.AbstractVaadinChartExample;
import com.peter.vaadin.components.vaadin.chart.SkipFromDemo;
import com.vaadin.ui.Component;

import java.io.Serializable;

@SkipFromDemo
public class BeansFromContainer extends AbstractVaadinChartExample {

    @Override
    public String getDescription() {
        return "Simple Chart with BeanItemContainer";
    }

    @Override
    protected Component getChart() {
        // Set up container & data
        BeanItemContainer<ClaimsReportItem> container = new BeanItemContainer<ClaimsReportItem>(
                ClaimsReportItem.class);
        container.addBean(new ClaimsReportItem("manual", 100));
        container.addBean(new ClaimsReportItem("automatic", 600));

        // Create ContainerSeries
        ContainerDataSeries series = new ContainerDataSeries(container);
        series.setName("Claims");
        series.setPlotOptions(new PlotOptionsColumn());
        series.setYPropertyId("amount");
        series.setNamePropertyId("type");

        // Create chart & configuration
        Chart chart = new Chart();
        Configuration configuration = chart.getConfiguration();
        configuration.getTitle().setText("Claim Processing");

        // Create Y Axis
        YAxis y = new YAxis();
        y.setTitle("Amount");
        configuration.addyAxis(y);

        // use category names from beans on x axis instead of index
        configuration.getxAxis().setType(AxisType.CATEGORY);
        configuration.setSeries(series);

        chart.setSizeFull();

        return chart;
    }

    public static class ClaimsReportItem implements Serializable {
        private String type;
        private Integer amount;

        public ClaimsReportItem(String type, Integer amount) {
            this.type = type;
            this.amount = amount;
        }

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

}
package com.peter.vaadin.components.vaadin.chart.themes;

import com.peter.vaadin.components.vaadin.chart.pie.PieChart;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
public class VaadinThemedPieChart extends PieChart {

    @Override
    public String getDescription() {
        return "Vaadin themed: " + super.getDescription();
    }

    @Override
    protected Component getChart() {
        // Vaadin theme is on by default
        // ChartTheme.get().setTheme(new VaadinTheme());
        return super.getChart();
    }

}

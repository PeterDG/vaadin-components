package com.peter.vaadin.components.vaadin.chart.themes;

import com.vaadin.addon.charts.ChartOptions;
import com.peter.vaadin.components.vaadin.chart.columnandbar.BarWithNegativeStack;
import com.vaadin.addon.charts.themes.SkiesTheme;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
public class SkiesThemedBarChart extends BarWithNegativeStack {

    @Override
    public String getDescription() {
        return "Skies themed: " + super.getDescription();
    }

    @Override
    protected Component getChart() {
        ChartOptions.get().setTheme(new SkiesTheme());
        return super.getChart();
    }

}

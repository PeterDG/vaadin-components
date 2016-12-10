package com.peter.vaadin.components.vaadin.chart.themes;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.ChartOptions;
import com.peter.vaadin.components.vaadin.chart.columnandbar.BarWithNegativeStack;
import com.vaadin.addon.charts.themes.GridTheme;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
public class GridThemedBarChart extends BarWithNegativeStack {

    @Override
    public String getDescription() {
        return "Grid themed: " + super.getDescription();
    }

    @Override
    protected Component getChart() {
        ChartOptions.get().setTheme(new GridTheme());
        Chart chart = (Chart) super.getChart();
        // chart.getConfiguration().getyAxis().setMinorTickInterval("auto");
        return chart;
    }

}

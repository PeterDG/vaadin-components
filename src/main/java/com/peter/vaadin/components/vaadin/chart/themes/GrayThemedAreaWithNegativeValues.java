package com.peter.vaadin.components.vaadin.chart.themes;

import com.vaadin.addon.charts.ChartOptions;
import com.peter.vaadin.components.vaadin.chart.area.AreaWithNegativeValues;
import com.vaadin.addon.charts.themes.GrayTheme;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
public class GrayThemedAreaWithNegativeValues extends AreaWithNegativeValues {

    @Override
    public String getDescription() {
        return "Gray themed: " + super.getDescription();
    }

    @Override
    protected Component getChart() {
        ChartOptions.get().setTheme(new GrayTheme());
        return super.getChart();
    }

}

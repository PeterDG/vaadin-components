package com.peter.vaadin.components.vaadin.chart.combinations;

import com.vaadin.addon.charts.Chart;
import com.peter.vaadin.components.vaadin.chart.AbstractVaadinChartExample;
import com.peter.vaadin.components.vaadin.chart.SkipFromDemo;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@SkipFromDemo
public class MultipleAxesWithResetZoom extends AbstractVaadinChartExample {

    @Override
    public String getDescription() {
        return "Multiple axes with reset zoom button";
    }

    @Override
    protected Component getChart() {
        final Chart chart = (Chart) new MultipleAxes().getChart();
        chart.getConfiguration().getTooltip().setEnabled(false);
        Button button = new Button("Reset zoom", new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                chart.getConfiguration().resetZoom();
            }
        });
        return new VerticalLayout(chart, button);
    }

}

/*
@VaadinAddonLicenseForJavaFiles@
 */
package com.peter.vaadin.components.vaadin.chart.timeline;

import com.vaadin.addon.timeline.Timeline;
import com.vaadin.data.Container;
import com.peter.vaadin.components.vaadin.chart.AbstractVaadinChartExample;
import com.peter.vaadin.components.vaadin.chart.SkipFromDemo;
import com.vaadin.ui.Component;

@SkipFromDemo
@SuppressWarnings({ "serial", "deprecation" })
public class InterpolationTest extends AbstractVaadinChartExample {

    private Timeline timeline;

    public InterpolationTest() {
        setSizeFull();

        timeline = new Timeline("Sparse Data");
        timeline.setSizeFull();
        timeline.setVerticalAxisRange(0F, 5F);

        // Add some zoom levels
        timeline.addZoomLevel("Day", 86400000L);
        timeline.addZoomLevel("Week", 7 * 86400000L);
        timeline.addZoomLevel("Month", 2629743830L);

        Container.Indexed source = TestContainers.createSparseContainer();
        timeline.addGraphDataSource(source);

        addComponent(timeline);
    }

    @Override
    protected Component getChart() {
        return null;
    }

    @Override
    protected void setup() {
    }
}

/*
@VaadinAddonLicenseForJavaFiles@
 */
package org.peter.vaadin.component.chart.timeline;

import com.vaadin.addon.timeline.Timeline;
import com.vaadin.data.Container;
import org.peter.vaadin.component.chart.AbstractVaadinChartExample;
import org.peter.vaadin.component.chart.SkipFromDemo;
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

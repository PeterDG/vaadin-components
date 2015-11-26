package org.peter.vaadin.component.chart.timeline;

import com.vaadin.addon.timeline.Timeline;
import com.vaadin.addon.timeline.Timeline.DateRangeChangedEvent;
import com.vaadin.addon.timeline.Timeline.DateRangeListener;
import org.peter.vaadin.component.chart.AbstractVaadinChartExample;
import org.peter.vaadin.component.chart.SkipFromDemo;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;

import java.util.Date;

@SkipFromDemo
@SuppressWarnings({ "serial", "deprecation" })
public class GetSetDateRangeTest extends AbstractVaadinChartExample implements
        DateRangeListener {

    private final Timeline timeline;

    private Date lastStartDate, lastEndDate;

    public GetSetDateRangeTest() {

        timeline = new Timeline();
        timeline.setSizeFull();
        timeline.addGraphDataSource(TestContainers
                .createSmoothContainer(123312321));
        timeline.addListener(this);
        timeline.addZoomLevel("1 month", 86400000L);
        timeline.setId("timeline");
        addComponent(timeline);
        setExpandRatio(timeline, 1);

        lastStartDate = timeline.getVisibleSelectionStart();
        lastEndDate = timeline.getVisibleSelectionEnd();

        Button reset = new Button("Reset", new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                System.out.println("Setting selection to " + lastStartDate
                        + " - " + lastEndDate);
                timeline.setVisibleDateRange(lastStartDate, lastEndDate);
            }
        });
        reset.setId("reset-button");
        addComponent(reset);
    }

    public void dateRangeChanged(DateRangeChangedEvent event) {
        lastStartDate = event.getStartDate();
        lastEndDate = event.getEndDate();
        System.out.println("Selection is now " + lastStartDate + " - "
                + lastEndDate);
    }

    @Override
    protected Component getChart() {
        return null;
    }

    @Override
    protected void setup() {
    }
}

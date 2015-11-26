package org.peter.vaadin.component.chart.dynamic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vaadin.addon.charts.*;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import org.peter.vaadin.component.chart.AbstractVaadinChartExample;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class ClickToAddPoint extends AbstractVaadinChartExample {

    private Chart chart;
    private Label lastAction = new Label();
    private Label eventDetails = new Label();

    @Override
    public String getDescription() {
        return "Click to add point";
    }

    @Override
    protected Component getChart() {
        lastAction.setId("lastAction");
        eventDetails.setId("eventDetails");
        chart = new Chart();
        chart.setId("chart");
        chart.setWidth("500px");

        final Configuration configuration = chart.getConfiguration();
        configuration.getChart().setType(ChartType.SCATTER);
        configuration.getTitle().setText("User supplied data");
        configuration
                .getSubTitle()
                .setText(
                        "Click the plot area to add a point. Click a point to remove it.");

        Axis xAxis = configuration.getxAxis();
        xAxis.setMinPadding(0.2);
        xAxis.setMaxPadding(0.2);

        YAxis yAxis = configuration.getyAxis();
        yAxis.setTitle(new Title("Value"));
        yAxis.setPlotLines(new PlotLine(0, 1, new SolidColor("#808080")));
        yAxis.setMinPadding(0.2);
        yAxis.setMaxPadding(0.2);

        Legend legend = configuration.getLegend();
        legend.setEnabled(false);
        configuration.setExporting(false);

        PlotOptionsSeries opt = new PlotOptionsSeries();
        opt.setLineWidth(1);
        configuration.setPlotOptions(opt);

        final DataSeries series = new DataSeries();
        series.add(new DataSeriesItem(20, 20));
        series.add(new DataSeriesItem(80, 80));
        configuration.setSeries(series);

        chart.drawChart(configuration);
        chart.addChartClickListener(new ChartClickListener() {

            @Override
            public void onClick(ChartClickEvent event) {
                double x = Math.round(event.getxAxisValue());
                double y = Math.round(event.getyAxisValue());
                series.add(new DataSeriesItem(x, y));
                lastAction.setValue("Added point " + x + "," + y);
                eventDetails.setValue(createEventString(event));
            }
        });

        chart.addPointClickListener(new PointClickListener() {

            @Override
            public void onClick(PointClickEvent event) {
                DataSeries ds = (DataSeries) event.getSeries();
                DataSeriesItem dataSeriesItem2 = ds.get(event.getPointIndex());
                ds.remove(dataSeriesItem2);
                lastAction.setValue("Removed point at index "
                        + event.getPointIndex());
                eventDetails.setValue(createEventString(event));
            }
        });
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(chart);
        verticalLayout.addComponent(lastAction);
        verticalLayout.addComponent(eventDetails);
        return verticalLayout;
    }

    private String createEventString(Component.Event event) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(event);
    }

    @Override
    protected void setup() {
        super.setup();
        final CheckBox checkbox = new CheckBox("Animate additions");
        checkbox.setImmediate(true);
        checkbox.setValue(true);
        checkbox.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChange(ValueChangeEvent event) {
                chart.getConfiguration().getChart()
                        .setAnimation(checkbox.getValue());
            }
        });
        addComponentAsFirst(checkbox);
    }
}

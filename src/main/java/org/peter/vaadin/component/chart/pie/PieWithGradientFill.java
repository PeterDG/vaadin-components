package org.peter.vaadin.component.chart.pie;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.GradientColor;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.data.Property;
import org.peter.vaadin.component.chart.AbstractVaadinChartExample;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class PieWithGradientFill extends AbstractVaadinChartExample {

    @Override
    public String getDescription() {
        return "Pie with gradient fill";
    }

    @Override
    protected Component getChart() {
        Chart chart = new Chart(ChartType.PIE);

        Configuration conf = chart.getConfiguration();

        conf.setTitle("Browser market shares at a specific website, 2010");

        PlotOptionsPie plotOptions = new PlotOptionsPie();
        plotOptions.setCursor(Cursor.POINTER);
        Labels dataLabels = new Labels();
        dataLabels.setEnabled(true);
        dataLabels.setColor(SolidColor.BLACK);
        dataLabels.setConnectorColor(SolidColor.BLACK);
        dataLabels
                .setFormatter("'<b>'+ this.point.name +'</b>: '+ this.percentage +' %'");
        plotOptions.setDataLabels(dataLabels);
        conf.setPlotOptions(plotOptions);
        final DataSeries series = getBrowserMarketShareSeries();
        conf.setSeries(series);

        chart.drawChart();
        VerticalLayout layout = new VerticalLayout();
        layout.addComponent(chart);
        CheckBox button = new CheckBox("Slice one part");
        button.addValueChangeListener(new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                series.setItemSliced(1, ((Boolean) event.getProperty()
                        .getValue()).booleanValue());
            }
        });
        layout.addComponent(button);
        return layout;
    }

    private DataSeries getBrowserMarketShareSeries() {
        DataSeriesItem firefox = new DataSeriesItem("Firefox", 45.0);
        firefox.setColor(createRadialGradient(new SolidColor(255, 128, 0),
                new SolidColor(128, 64, 0)));

        DataSeriesItem ie = new DataSeriesItem("IE", 26.8);
        ie.setColor(createRadialGradient(new SolidColor(0, 255, 255),
                new SolidColor(0, 128, 128)));

        DataSeriesItem chrome = new DataSeriesItem("Chrome", 12.8);
        chrome.setColor(createRadialGradient(new SolidColor(255, 255, 0),
                new SolidColor(128, 128, 0)));
        chrome.setSliced(true);
        chrome.setSelected(true);

        DataSeriesItem safari = new DataSeriesItem("Safari", 8.5);
        safari.setColor(createRadialGradient(new SolidColor(0, 128, 255),
                new SolidColor(0, 64, 128)));

        DataSeriesItem opera = new DataSeriesItem("Opera", 6.2);
        opera.setColor(createRadialGradient(new SolidColor(255, 0, 0),
                new SolidColor(128, 0, 0)));

        DataSeriesItem others = new DataSeriesItem("Others", 0.7);
        others.setColor(createRadialGradient(new SolidColor(0, 128, 0),
                new SolidColor(0, 64, 0)));

        return new DataSeries(firefox, ie, chrome, safari, opera, others);
    }

    /**
     * Creates a radial gradient with the specified start and end colors.
     */
    private GradientColor createRadialGradient(SolidColor start, SolidColor end) {
        GradientColor color = GradientColor.createRadial(0.5, 0.3, 0.7);
        color.addColorStop(0, start);
        color.addColorStop(1, end);
        return color;
    }

}

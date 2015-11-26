package org.peter.vaadin.component.chart.container;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.ContainerDataSeries;
import com.vaadin.addon.charts.model.Series;
import com.vaadin.addon.charts.model.style.Color;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import org.peter.vaadin.component.chart.AbstractVaadinChartExample;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;

public class SimpleChartWithContainerSeries extends AbstractVaadinChartExample {

    @Override
    public String getDescription() {
        return "Simple Chart with ContainerSeries";
    }

    @Override
    protected Component getChart() {
        HorizontalLayout lo = new HorizontalLayout();
        ContainerDataSeries container = createContainer();
        Component table = createTable(container.getVaadinContainer());
        Component chart = createChart(container);

        table.setSizeFull();
        chart.setSizeFull();

        lo.setWidth("100%");
        lo.setHeight("450px");
        lo.addComponents(table);
        lo.addComponent(chart);
        return lo;
    }

    @SuppressWarnings("unchecked")
    private ContainerDataSeries createContainer() {
        IndexedContainer vaadinContainer = new IndexedContainer();
        ContainerDataSeries container = new ContainerDataSeries(vaadinContainer);
        vaadinContainer.addContainerProperty("name", String.class, null);
        vaadinContainer.addContainerProperty("y", Number.class, null);
        vaadinContainer.addContainerProperty("color", Color.class, null);

        container.setName("Browser share");

        container.setYPropertyId("y");
        container.setNamePropertyId("name");
        container.addAttributeToPropertyIdMapping("color", "color");

        String[] names = new String[] { "MSIE", "Firefox", "Chrome", "Safari",
                "Opera" };
        Number[] values = new Number[] { 55.11, 21.63, 11.94, 7.15, 2.14 };
        Color[] colors = getThemeColors();

        for (int i = 0; i < names.length; i++) {
            Item ie = vaadinContainer.addItem(i);
            ie.getItemProperty("name").setValue(names[i]);
            ie.getItemProperty("y").setValue(values[i]);
            ie.getItemProperty("color").setValue(colors[i]);
        }

        return container;
    }

    private Component createTable(Container container) {
        Table t = new Table();
        t.setCaption("Data from Vaadin Container");
        t.setContainerDataSource(container);
        t.setImmediate(true);
        return t;
    }

    public static Chart createChart(Series container) {
        final Chart chart = new Chart();

        final Configuration configuration = chart.getConfiguration();
        configuration.getChart().setType(ChartType.PIE);
        configuration.getTitle().setText("Data from Vaadin Container");

        configuration.setSeries(container);

        chart.drawChart(configuration);

        return chart;
    }
}

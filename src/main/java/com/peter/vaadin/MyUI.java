package com.peter.vaadin;

import javax.servlet.annotation.WebServlet;

import com.peter.vaadin.components.others.SubWindow;
import com.peter.vaadin.components.others.mycomponent.MyComponent;
import com.peter.vaadin.components.vaadin.chart.timeline.Candlestick;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.peter.vaadin.components.vaadin.InlineTextEditor;
import com.peter.vaadin.components.others.applet.AppletIntegrationSampleUI;
import com.peter.vaadin.components.vaadin.chart.area.AreaSpline;
import com.peter.vaadin.components.vaadin.googlemaps.MapGoogle;

/**
 *
 */
@Theme("mytheme")
@Widgetset("com.peter.vaadin.Widgetset")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking"));
            }
        });
        InlineTextEditor editor = new InlineTextEditor("It is a test");
        AreaSpline areaSpline=new AreaSpline();
        MapGoogle mapGoogle = new MapGoogle();
        AppletIntegrationSampleUI applet = new AppletIntegrationSampleUI();
        SubWindow subWindow =new SubWindow();
        MyComponent myComponent =new MyComponent();
        myComponent.setMyIcon(new ThemeResource("img/pig-128px.png"));
        layout.addComponent(button);
        layout.addComponent(editor);
        layout.addComponent(areaSpline);
        layout.addComponent(mapGoogle);
        layout.addComponent(applet);
        layout.addComponent(myComponent);
        this.addWindow(subWindow);


//        topGrossingMoviesChart = new TopGrossingMoviesChart();
//::column and bar
//        BarWithNegativeStack topGrossingMoviesChart = new BarWithNegativeStack();
//        topGrossingMoviesChart = new BasicBar();
//          topGrossingMoviesChart = new BasicColumn();
//        BasicColumnWithPointWidthAndRange topGrossingMoviesChart = new BasicColumnWithPointWidthAndRange();
//        ColumnWithDrilldown topGrossingMoviesChart = new ColumnWithDrilldown();
//          topGrossingMoviesChart = new ColumnWithRotatedLabels();
//        ColumnWithNegativeValues topGrossingMoviesChart = new ColumnWithNegativeValues();
//        DualAxesLineAndColumn topGrossingMoviesChart = new DualAxesLineAndColumn();
//        StackedAndGroupedColumn topGrossingMoviesChart = new StackedAndGroupedColumn();
//        StackedBar topGrossingMoviesChart = new StackedBar();
//        StackedColumn topGrossingMoviesChart = new StackedColumn();
//        StackedPercentageColumn topGrossingMoviesChart = new StackedPercentageColumn();
//       ToggledSeriesVisibility topGrossingMoviesChart = new ToggledSeriesVisibility();
//::pie
//        DonutChart topGrossingMoviesChart = new DonutChart();
//        PieChart topGrossingMoviesChart = new PieChart();
//        PieChartWithCredits topGrossingMoviesChart = new PieChartWithCredits();
//        PieWithGradientFill topGrossingMoviesChart = new PieWithGradientFill();
//        PieWithLegend topGrossingMoviesChart = new PieWithLegend ();
//        PieWithStartAndEndAngle topGrossingMoviesChart = new PieWithStartAndEndAngle ();
//::area
//        AreaSpline topGrossingMoviesChart = new AreaSpline ();
//        AreaWithMissingPoints topGrossingMoviesChart = new AreaWithMissingPoints();
//        AreaWithNegativeValues topGrossingMoviesChart = new AreaWithNegativeValues();
//        BasicArea topGrossingMoviesChart = new BasicArea();
//        InvertedAxes topGrossingMoviesChart = new InvertedAxes();
//        PercentageArea topGrossingMoviesChart = new PercentageArea();
//        StackedArea topGrossingMoviesChart = new StackedArea();
//::line and scatter
//        BasicLine topGrossingMoviesChart = new BasicLine();
//        BasicLineGettingMousePointerPosition topGrossingMoviesChart = new BasicLineGettingMousePointerPosition();
//        BasicLineWithCustomCrosshairs topGrossingMoviesChart = new BasicLineWithCustomCrosshairs();
//        BasicLineWithDataLabels topGrossingMoviesChart = new BasicLineWithDataLabels();
//        DateAxisAndClickEvent topGrossingMoviesChart = new DateAxisAndClickEvent();
//        LargeDataSet topGrossingMoviesChart = new LargeDataSet();
//        LineWithDashSelector topGrossingMoviesChart = new LineWithDashSelector ();
//        LinesWithComplexHtmlTooltip topGrossingMoviesChart = new LinesWithComplexHtmlTooltip();
//        LogarithmicAxis topGrossingMoviesChart = new LogarithmicAxis();
//        SplineInverted topGrossingMoviesChart = new SplineInverted();
//        SplineUpdatingEachSecond topGrossingMoviesChart = new SplineUpdatingEachSecond();
//        SplineWithPlotBandRemoveFunctionality topGrossingMoviesChart = new SplineWithPlotBandRemoveFunctionality();
//        SplineWithPlotBands topGrossingMoviesChart = new SplineWithPlotBands();
//        SplineWithSymbols topGrossingMoviesChart = new SplineWithSymbols();
//        StepLines topGrossingMoviesChart = new StepLines();
//        TimeDataWithIrregularIntervals topGrossingMoviesChart = new TimeDataWithIrregularIntervals();
//        TimeSeriesZoomable topGrossingMoviesChart = new TimeSeriesZoomable();
//        UtcTimeDataAndTooltipDateFormat topGrossingMoviesChart = new UtcTimeDataAndTooltipDateFormat();
//::dynamic
//        ClickToAddPoint topGrossingMoviesChart = new ClickToAddPoint();
//        DynamicExtremes topGrossingMoviesChart = new DynamicExtremes();
//        Events topGrossingMoviesChart = new Events();
//        MasterDetailChart topGrossingMoviesChart = new MasterDetailChart();
//        ModifyOnePoint topGrossingMoviesChart = new ModifyOnePoint();
//        WebXYChartSelection topGrossingMoviesChart = new WebXYChartSelection();
//::combinations
//          ColumnLineAndPie topGrossingMoviesChart = new ColumnLineAndPie();
//          DualCharts topGrossingMoviesChart = new DualCharts();
//          MultipleAxes topGrossingMoviesChart = new MultipleAxes();
//          ScatterWithRegressionLine topGrossingMoviesChart = new ScatterWithRegressionLine();
//::other
//        AngularGauge topGrossingMoviesChart = new AngularGauge();
//        AreaRange topGrossingMoviesChart = new AreaRange();
//        BoxPlotExample topGrossingMoviesChart = new BoxPlotExample();
//        BubbleChartExample topGrossingMoviesChart = new BubbleChartExample();
//        Clock topGrossingMoviesChart = new Clock();
//        ColorThreshold topGrossingMoviesChart = new ColorThreshold ();
//        ColumnRange topGrossingMoviesChart = new ColumnRange();
//        ColumnRangeResourceUsage topGrossingMoviesChart = new ColumnRangeResourceUsage();
//        ErrorBarExample topGrossingMoviesChart = new ErrorBarExample();
//        ExportingExample topGrossingMoviesChart = new ExportingExample ();
//        FunnelChartExample topGrossingMoviesChart = new FunnelChartExample();
//        GaugeWithDualAxes topGrossingMoviesChart = new GaugeWithDualAxes();
//        JSAndJavaApi topGrossingMoviesChart = new JSAndJavaApi();
//        PolarChart topGrossingMoviesChart = new PolarChart();
//        PyramidChartExample topGrossingMoviesChart = new PyramidChartExample();
//        ResizeInsideVaadinComponent topGrossingMoviesChart = new ResizeInsideVaadinComponent();
//        SolidGauge topGrossingMoviesChart = new SolidGauge();
//        Spiderweb topGrossingMoviesChart = new Spiderweb();
//        VUMeter topGrossingMoviesChart = new VUMeter();
//        WaterfallChartExample topGrossingMoviesChart = new WaterfallChartExample();
//        WindRose topGrossingMoviesChart = new WindRose();

//::container
//        ContainerWithLotsOfData topGrossingMoviesChart=new ContainerWithLotsOfData();
//        SimpleChartWithContainerSeries topGrossingMoviesChart=new SimpleChartWithContainerSeries();
//        ChartWithExternalContainer topGrossingMoviesChart = new ChartWithExternalContainer();
//::timeline
//        ForumTrends topGrossingMoviesChart = new ForumTrends();
//::3D
//        weeklyEfficiencyColumn = new WeeklyEfficiencyColumn();
//        Basic3DPie topGrossingMoviesChart = new Basic3DPie();
//        Basic3DScatter topGrossingMoviesChart = new Basic3DScatter();
//::GoogleMaps
//        MapGoogle topGrossingMoviesChart = new MapGoogle();
//::Applets
//        AppletIntegrationSampleUI applet = new AppletIntegrationSampleUI();
//::ui
//        WeekCalendar topGrossingMoviesChart =new WeekCalendar();


    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}

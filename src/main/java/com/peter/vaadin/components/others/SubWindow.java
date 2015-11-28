package com.peter.vaadin.components.others;


import com.peter.vaadin.components.others.applet.AppletIntegrationSampleUI;
import com.peter.vaadin.components.others.mycomponent.MyComponent;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.window.WindowMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;


/**
 * Created by Peter on 4/26/15.
 */

public class SubWindow extends Window {

    public AppletIntegrationSampleUI appletWidget;

    private int defaultWidth = 295;
    private int defaultHeight = 300;
    private int dx = 2;
    private int dy = 67;
    private int dxWidget = 2;
    private int dyWidget = 36;
    private TextField tHeight = new TextField();
    private TextField twidth = new TextField();

    public SubWindow() {
        super("Localizacion"); // Set window caption

        setWindowMode(WindowMode.NORMAL);
        setClosable(true);

        setWidth(defaultWidth + "px");
        setHeight(defaultHeight + "px");
        setPositionX(5);
        setPositionY(Page.getCurrent().getBrowserWindowHeight() - (int) this.getHeight() - 5);
        setContent(buildContent());
        addResizeListener(event -> {
            tHeight.setValue(String.valueOf(this.getHeight()));
            twidth.setValue(String.valueOf(this.getWidth()));
            setAppletView(this.getWidth(),this.getHeight());
        });
        addWindowModeChangeListener(event -> {
            tHeight.setValue(String.valueOf(this.getHeight()));
            twidth.setValue(String.valueOf(this.getWidth()));
            if(event.getWindowMode().equals(WindowMode.MAXIMIZED)) setAppletView((float)Page.getCurrent().getBrowserWindowWidth()-10, (float) Page.getCurrent().getBrowserWindowHeight()-10);
            if(event.getWindowMode().equals(WindowMode.NORMAL)) setAppletView((float) defaultWidth, (float) defaultHeight);
        });
    }

    private void setAppletView(Float WindowWidth,Float WindowHeight){
        appletWidget.applet.executeCommand("setSize", new String[]{Float.toString(WindowWidth - dx), Float.toString(WindowHeight - dy)});
        appletWidget.setWidth(WindowWidth - dxWidget + "px");
        appletWidget.setHeight(WindowHeight -dyWidget + "px");
    }

    private Component buildContent() {
        HorizontalLayout content = new HorizontalLayout();
        content.setMargin(false);
        content.addComponent(buildApplet());
//        content.addComponent(tHeight);
//        content.addComponent(twidth);
//        content.addComponent(buildMyComponent());
        return content;
    }

    private Component buildMyComponent() {
        MyComponent component = new MyComponent();
        component.setMyIcon(new ThemeResource("img/pig-128px.png"));
        return component;
    }

    private Component buildApplet() {
        appletWidget = new AppletIntegrationSampleUI();
        setAppletView(this.getWidth(),this.getHeight());
        return appletWidget;
    }

//        addResizeListener(event -> {
//            appletLocation.applet.setVisible(false);
//            appletLocation.applet.setSizeFull();
//            getUI().access(new Runnable() {
//                @Override
//                public void run() {
//                    int heightE = (int) event.getWindow().getHeight();
//                    int widthE = (int) event.getWindow().getWidth();
//                    appletLocation.applet.executeCommand("setSize", new String[]{Integer.toString(widthE - dx), Integer.toString(heightE - dy)});
//                    appletLocation.applet.setHeight(heightE * 2 + "px");
//                    appletLocation.applet.setWidth(widthE + "px");
//                }
//            });
//            appletLocation.applet.setVisible(true);
//
//        });
//
////            appletLocation.applet.executeCommand("setSize", new String[]{width_str,height_str});
//
//        });
//        // Trivial logic for closing the sub-window
//        Button ok = new Button("OK");
//        ok.addClickListener(new Button.ClickListener() {
//            public void buttonClick(Button.ClickEvent event) {
//                // Close the sub-window
//                close();
//            }
//        });
//        content.addComponent(ok);


//    public class BackgroundThread extends Thread {
//
//        @Override
//        public void run() {
//            // Simulate background work
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//            }
//
//            // Update UI
//            synchronized (SubWindow.this) {
//               getUI().addComponent(new Label("All done"));
//            }
//
//            // Push the changes
//            pusher.push();
//        }


    public AppletIntegrationSampleUI getAppletWidget() {
        return appletWidget;
    }

}


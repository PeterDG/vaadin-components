package com.peter.vaadin.components.others.grid;


import com.vaadin.server.Resource;
import com.vaadin.ui.*;
import com.vaadin.ui.renderers.ImageRenderer;

import java.util.List;

/**
 * Created by Peter on 6/15/15.
 */
public class Summary  extends CustomComponent {
    public Grid grid;
    VerticalLayout layout;
    public Summary() {
        layout =new VerticalLayout();
        summary(layout);
        setCompositionRoot(layout);
        layout.setSizeFull();
      //  summary(this.l);
    }

    public void addRows(List<SummaryData> data){
        summary(layout);
        for(SummaryData d:data){
            grid.addRow(d.name,d.resource,d.value);
        }
//        grid.addRow("Tableros", new ThemeResource("img/summary/boardtable-40px.png"), 10);
//        grid.addRow("Mesas", new ThemeResource("img/summary/table-40px.png"), 20);
//        grid.addRow("Sillas", new ThemeResource("img/summary/chair-40px.png"), 36);
//        grid.addRow("Ventanas", new ThemeResource("img/summary/window-40px.png"), 40);

    }

    public Summary(String message) {
        // A layout structure used for composition
        VerticalLayout panel =new VerticalLayout();

        // Compose from multiple components
        Label label = new Label(message);
        label.setSizeUndefined(); // Shrink
        panel.addComponent(label);
        panel.addComponent(new Button("Ok"));

        // Set the size as undefined at all levels
        panel.setSizeUndefined();
        setSizeUndefined();

        // The composition root MUST be set
        setCompositionRoot(panel);
    }

    public void summary(VerticalLayout layout) {
        layout.removeAllComponents();
        grid = new Grid();
        grid.setWidth("97%");
        grid.setHeight("50%");

        grid.setStyleName("gridwithpics128px");
        grid.setSelectionMode(Grid.SelectionMode.NONE);

        // Define some columns
        grid.addColumn("item", String.class);
        grid.addColumn("imagen", Resource.class).setRenderer(new ImageRenderer());
        grid.addColumn("valor", Double.class);

        grid.setCellStyleGenerator(cell ->
                "imagen".equals(cell.getPropertyId()) ? "imagecol" : null);
        grid.setCellStyleGenerator(cell ->
                "item".equals(cell.getPropertyId())? "namecol" : null);

        Grid.Column nameColumn = grid.getColumn("item");
        nameColumn.setExpandRatio(1);
        Grid.Column pictureColumn = grid.getColumn("imagen");
        pictureColumn.setExpandRatio(3);
        Grid.Column valueColumn = grid.getColumn("valor");
        valueColumn.setExpandRatio(2);

//        grid.setCellStyleGenerator(cellReference -> // Java 8
//                "description".equals(cellReference.getPropertyId())?
//                        "wrappingcolumn" : null);

        layout.addComponent(grid);

//        // Create a grid
//        Grid grid = new Grid();
//        grid.setSelectionMode(Grid.SelectionMode.NONE);
//        grid.setWidth("600px");
//        grid.setHeight("250px");
//        grid.setStyleName("gridwithpics128px");
//
//// Define some columns
//        grid.addColumn("name", String.class);
//        grid.addColumn("picture", Resource.class).setRenderer(new ImageRenderer());
//        grid.addColumn("value", Double.class);
//
//// This column expands just a bit
//        Grid.Column bornColumn = grid.getColumn("name");
//        bornColumn.setMinimumWidth(5);
//        bornColumn.setMaximumWidth(20);
//        bornColumn.setExpandRatio(1);
//
//        Grid.Column valueColumn = grid.getColumn("value");
//        valueColumn.setExpandRatio(30);
//// This column expands 5 times more
//        Grid.Column ratingColumn = grid.getColumn("picture");
////        ratingColumn.setMinimumWidth(100);
////        ratingColumn.setMaximumWidth(400);
//        ratingColumn.setExpandRatio(50);
//
//        grid.setCellStyleGenerator(cellReference -> // Java 8
//                "description".equals(cellReference.getPropertyId()) ?
//                        "wrappingcolumn" : null);
//
//// Add some data rows
//        grid.addRow("Tableros", new ThemeResource("img/summary/boardtable-48px.png"), 0.1);
//        grid.addRow("Sillas",     new ThemeResource("img/summary/chair-48px.png"),  0.42);
//        grid.addRow("Mesas",     new ThemeResource("img/summary/table-48px.png"), 1.0);
////        grid.addRow("Tableros", new ThemeResource("img/summary/boardtable-48px.png"), 0.1);
////        grid.addRow("Sillas",     new ThemeResource("img/summary/chair-48px.png"), 0.42);
////        grid.addRow("Mesas",     new ThemeResource("img/summary/table-48px.png"), 1.0);
//        layout.addComponent(grid);

    }

//    public void summary(VerticalLayout layout, List<SummaryData>) {
//
//    }
}

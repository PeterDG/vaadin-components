package com.peter.vaadin.components.others.grid;

import com.vaadin.server.Resource;

/**
 * Created by Peter on 6/16/15.
 */
public class SummaryData {
    public String name;
    public Resource resource;
    public double value;

    public SummaryData(String name, Resource resource, Double value) {
        this.name = name;
        this.resource = resource;
        this.value = value;
    }

}

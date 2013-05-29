package com.motorola.medios.cis.ui.menu.model;

import java.io.Serializable;

/*
 * Copyright 2013 Motorola Mobility, All rights reserved.
 */
public class MenuNode implements Serializable {

    private String name;
    private String view;

    public MenuNode(final String name, final String view) {
        this.name = name;
        this.view = view;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
}

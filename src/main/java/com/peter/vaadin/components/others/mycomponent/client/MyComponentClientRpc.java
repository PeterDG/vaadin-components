package com.peter.vaadin.components.others.mycomponent.client;

import com.vaadin.shared.communication.ClientRpc;

public interface MyComponentClientRpc extends ClientRpc {

	// TODO example API
    public void alert(String message);

}
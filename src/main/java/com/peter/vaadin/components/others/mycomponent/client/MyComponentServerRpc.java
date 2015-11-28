package com.peter.vaadin.components.others.mycomponent.client;

import com.vaadin.shared.communication.ServerRpc;

public interface MyComponentServerRpc extends ServerRpc {

	// TODO example API
    public void clicked(String buttonName);

}

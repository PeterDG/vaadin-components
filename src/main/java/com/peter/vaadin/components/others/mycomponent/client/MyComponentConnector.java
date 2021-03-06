/*
 * Copyright 2013 HPD Software Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.peter.vaadin.components.others.mycomponent.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.peter.vaadin.components.others.mycomponent.MyComponent;
import com.peter.vaadin.components.others.mycomponent.client.MyComponentClientRpc;
import com.vaadin.client.MouseEventDetailsBuilder;
import com.vaadin.client.annotations.OnStateChange;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.ui.Connect;

/**
 * A Trivial connector, to explore compiling WidgetSets
 *
 * From https://vaadin.com/wiki/-/wiki/Main/Creating%20a%20simple%20component
 */
@Connect(MyComponent.class)
public class MyComponentConnector extends AbstractComponentConnector {

  public MyComponentConnector() {
    registerRpc(MyComponentClientRpc.class, new MyComponentClientRpc() {
      private static final long serialVersionUID = -1056192951789062628L;

      public void alert(String message) {
        // TODO Do something useful
        Window.alert(message);
      }
    });

    // TODO ServerRpc usage example, do something useful instead
    getWidget().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        final MouseEventDetails mouseDetails = MouseEventDetailsBuilder
                .buildMouseEventDetails(event.getNativeEvent(),
                        getWidget().getElement());
        MyComponentServerRpc rpc =
                getRpcProxy(MyComponentServerRpc.class);
        rpc.clicked(mouseDetails.getButtonName());
      }
    });

  }

  @Override
  protected Widget createWidget() {
    return GWT.create(MyComponentWidget.class);
  }



  @Override
  public MyComponentWidget getWidget() {
    return (MyComponentWidget) super.getWidget();
  }

  @Override
  public MyComponentState getState() {
    return (MyComponentState) super.getState();
  }

  @OnStateChange("text")
  void updateText() {
    getWidget().setText(getState().text);
  }

  @Override
  public void onStateChanged(StateChangeEvent stateChangeEvent) {
    super.onStateChanged(stateChangeEvent);

    // TODO do something useful
    final String text = getState().text;
    getWidget().setText(text);

    // Set a resource
    getWidget().setMyIcon(getResourceUrl("myIcon"));
  }

}

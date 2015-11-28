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
package com.peter.vaadin.components.others.mycomponent;


import com.peter.vaadin.components.others.mycomponent.client.MyComponentClientRpc;
import com.peter.vaadin.components.others.mycomponent.client.MyComponentServerRpc;
import com.peter.vaadin.components.others.mycomponent.client.MyComponentState;
import com.vaadin.server.Resource;
import com.vaadin.ui.AbstractComponent;

/**
 * A Trivial component, to explore compiling WidgetSets
 *
 * From https://vaadin.com/wiki/-/wiki/Main/Creating%20a%20simple%20component
 */
public class MyComponent extends AbstractComponent {

    private MyComponentServerRpc rpc = new MyComponentServerRpc() {
        private static final long serialVersionUID = -3384499731721458101L;

        private int clickCount = 0;

        @Override
        public void clicked(String buttonName) {
            // Nag every 5:th click using RPC
            if (++clickCount % 5 == 0) {
                getRpcProxy(MyComponentClientRpc.class).alert(
                        "Ok, that's enough!");
            }

            // Update shared state
            getState().text = "You have clicked " + clickCount +
                    " times, now " + buttonName;
        }
    };

    public MyComponent() {
        getState().text = "This is MyComponent";
        registerRpc(rpc);
    }

    @Override
    public MyComponentState getState() {
        return (MyComponentState) super.getState();
    }

    public void setMyIcon(Resource myIcon) {
        setResource("myIcon", myIcon);
    }

    public Resource getMyIcon() {
        return getResource("myIcon");
    }

}


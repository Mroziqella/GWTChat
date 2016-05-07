package pl.mroziqella.example.chat.client.view.listeners;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.*;
import pl.mroziqella.example.chat.client.view.*;

/**
 * Created by Kamil on 07/05/2016.
 */
public class ClickButtonRegister implements ClickHandler {
    @Override
    public void onClick(ClickEvent event) {
        RootPanel.get("slot2").clear();
        RootPanel.get("slot2").add(new RegisterWidget());
    }
}

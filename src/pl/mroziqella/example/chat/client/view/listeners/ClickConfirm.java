package pl.mroziqella.example.chat.client.view.listeners;

import com.google.gwt.event.dom.client.*;
import pl.mroziqella.example.chat.client.view.*;

/**
 * Created by Kamil on 08/05/2016.
 */
public class ClickConfirm implements ClickHandler {
    private boolean fieldStatus;
    public ClickConfirm(boolean fieldStatus) {
        this.fieldStatus = fieldStatus;
    }

    @Override
    public void onClick(ClickEvent event) {
        InviteWidget.setAcceptInvite(fieldStatus);

    }
}

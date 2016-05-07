package pl.mroziqella.example.chat.client.view.listeners;


import com.google.gwt.event.dom.client.*;

import com.google.gwt.user.client.rpc.*;
import com.google.gwt.user.client.ui.*;
import pl.mroziqella.example.chat.client.*;
import pl.mroziqella.example.chat.client.view.*;
import pl.mroziqella.example.chat.client.Throws.*;

import java.util.logging.*;

/**
 * Created by Kamil on 05/05/2016.
 */
public class ClickButton implements ClickHandler {
    private Label label;
    private TextBox login;
    private TextBox password;


    public ClickButton(Label label, TextBox login, TextBox password) {
        this.label = label;
        this.login = login;
        this.password = password;
    }

    @Override
    public void onClick(ClickEvent event) {
            RootPanel.get("slot1").add(new Label(login.getText()));
            ChatService.App.getInstance().userAccountExists(login.getText(), password.getText(), new MyAsyncCallback(label));

    }





    private static class MyAsyncCallback implements AsyncCallback<Boolean> {
        private Label label;

        public MyAsyncCallback(Label label) {
            this.label = label;
        }


        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }

        @Override
        public void onSuccess(Boolean result) {
            if(result) {
                RootPanel.get("slot2").clear();
                RootPanel.get("slot1").add(new ChatWidget());
            }
            else {
                label.setText("blad");
            }

        }
    }
}

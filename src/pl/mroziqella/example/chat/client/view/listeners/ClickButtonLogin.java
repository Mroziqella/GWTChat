package pl.mroziqella.example.chat.client.view.listeners;


import com.google.gwt.event.dom.client.*;

import com.google.gwt.user.client.rpc.*;
import com.google.gwt.user.client.ui.*;
import pl.mroziqella.example.chat.client.*;
import pl.mroziqella.example.chat.client.model.*;
import pl.mroziqella.example.chat.client.view.*;

/**
 * Created by Kamil on 05/05/2016.
 */
public class ClickButtonLogin implements ClickHandler {
    private Label label;
    private TextBox login;
    private TextBox password;


    public ClickButtonLogin(Label label, TextBox login, TextBox password) {
        this.label = label;
        this.login = login;
        this.password = password;
    }

    @Override
    public void onClick(ClickEvent event) {
            RootPanel.get("slot1").clear();
            RootPanel.get("slot1").add(new Label(login.getText()));
            ChatService.App.getInstance().userAccountExists(login.getText(), password.getText(), new MyAsyncCallback(label, login));

    }


    private static class MyAsyncCallback implements AsyncCallback<Boolean> {
        private Label label;
        private TextBox login;

        public MyAsyncCallback(Label label, TextBox login) {
            this.label = label;
            this.login = login;
        }


        public void onFailure(Throwable throwable) {
            label.setText("Błąd logowania!");
        }

        @Override
        public void onSuccess(Boolean result) {

              RootPanel.get("slot2").clear();
              Chat.serLoginSession(login.getText());
              RootPanel.get("slot1").add(new ChatWidget());

        }
    }
}

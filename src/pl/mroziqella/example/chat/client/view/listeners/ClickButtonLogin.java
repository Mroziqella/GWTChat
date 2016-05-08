package pl.mroziqella.example.chat.client.view.listeners;


import com.google.gwt.event.dom.client.*;

import com.google.gwt.user.client.*;
import com.google.gwt.user.client.rpc.*;
import com.google.gwt.user.client.ui.*;
import pl.mroziqella.example.chat.client.*;
import pl.mroziqella.example.chat.client.model.*;
import pl.mroziqella.example.chat.client.view.*;

/**
 * Created by Kamil on 05/05/2016.
 */
public class ClickButtonLogin implements ClickHandler {
    private TextBox login;
    private TextBox password;


    public ClickButtonLogin(TextBox login, TextBox password) {
        this.login = login;
        this.password = password;
    }

    public ClickButtonLogin(String login, String password) {
        this.login = new TextBox();
        this.password = new TextBox();
        this.login.setText(login);
        this.password.setText(password);

    }

    @Override
    public void onClick(ClickEvent event) {
            RootPanel.get("slot1").clear();
            RootPanel.get("slot2").add(new Label("Logowanie uzytkownika: "+login.getText()+"..."));
            Chat.setRoomName("all");
            Chat.setPassword(password.getText());
            ChatService.App.getInstance().userAccountExists(Chat.getRoomName(),login.getText(), password.getText(), new MyAsyncCallback(login));

    }


    private static class MyAsyncCallback implements AsyncCallback<Boolean> {
        private TextBox login;

        public MyAsyncCallback(TextBox login) {
            this.login = login;
        }


        public void onFailure(Throwable throwable) {
            RootPanel.get("slot2").clear();
            RootPanel.get("slot2").add(new LoginWidget());
            RootPanel.get("slot2").add(new Label("Błąd przy logowaniu użytkownika: "+login.getText()));
            Window.alert("Błędne hasło");
        }

        @Override
        public void onSuccess(Boolean result) {

              RootPanel.get("slot2").clear();
              Chat.serLoginSession(login.getText());
              RootPanel.get("slot1").add(new ChatWidget());

        }
    }
}

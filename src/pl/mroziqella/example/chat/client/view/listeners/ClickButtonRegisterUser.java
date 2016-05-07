package pl.mroziqella.example.chat.client.view.listeners;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.*;
import com.google.gwt.user.client.rpc.*;
import com.google.gwt.user.client.ui.*;
import pl.mroziqella.example.chat.client.*;
import pl.mroziqella.example.chat.client.Throws.*;
import pl.mroziqella.example.chat.client.view.*;

/**
 * Created by Kamil on 07/05/2016.
 */
public class ClickButtonRegisterUser implements ClickHandler {
    private Label label;
    private TextBox login;
    private PasswordTextBox password;
    private PasswordTextBox password2;

    public ClickButtonRegisterUser(Label label, TextBox login, PasswordTextBox password, PasswordTextBox password2) {
        this.label = label;
        this.login = login;
        this.password = password;
        this.password2 = password2;
    }

    @Override
    public void onClick(ClickEvent event) {
        if(password.getText().equals(password2.getText())) {
            ChatService.App.getInstance().addUser(login.getText(), password.getText(), new MyAsyncCallback(label));
        }else{
            label.setText("Różne hasla!");
        }

    }

    private static class MyAsyncCallback implements AsyncCallback<Void> {
        private Label label;

        public MyAsyncCallback(Label label) {
            this.label = label;
        }


        public void onFailure(Throwable throwable) {
            label.setText("Błąd rejestracji!");
        }

        @Override
        public void onSuccess(Void result) {

            RootPanel.get("slot2").clear();
            RootPanel.get("slot2").add(new LoginWidget());
            Window.alert("Zarejestrowano!");

        }
    }
}

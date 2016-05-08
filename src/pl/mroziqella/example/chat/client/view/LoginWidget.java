package pl.mroziqella.example.chat.client.view;

import com.google.gwt.event.logical.shared.*;
import com.google.gwt.user.client.*;
import com.google.gwt.user.client.ui.*;
import pl.mroziqella.example.chat.client.view.listeners.*;

import java.util.logging.*;

/**
 * Created by Kamil on 05/05/2016.
 */
public class LoginWidget extends VerticalPanel  {
    private TextBox login = new TextBox();
    private PasswordTextBox password = new PasswordTextBox();

    public LoginWidget() {
        super();

        Button loginButton = new Button("Zaloguj");
        Button registerButton = new Button("Zarejestruj");

        Grid grid = new Grid(4, 1);
        grid.setWidget(1, 0, login);
        grid.setWidget(2, 0, password);
        HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.add(loginButton);
        horizontalPanel.add(registerButton);
        grid.setWidget(3,0,horizontalPanel);

        loginButton.addClickHandler(new ClickButtonLogin(login,password));
        registerButton.addClickHandler(new ClickButtonRegister());
        this.add(grid);


    }


}

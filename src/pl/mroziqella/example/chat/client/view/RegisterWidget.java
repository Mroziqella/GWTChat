package pl.mroziqella.example.chat.client.view;

import com.google.gwt.user.client.ui.*;
import pl.mroziqella.example.chat.client.view.listeners.*;

/**
 * Created by Kamil on 07/05/2016.
 */
public class RegisterWidget extends VerticalPanel {
    private TextBox login;
    private PasswordTextBox password;
    private PasswordTextBox password2;
    private Label labelInfo;

    public RegisterWidget() {
        Button registerButton = new Button("Rejestruj!");
        login =  new TextBox();
        password = new PasswordTextBox();
        password2 = new PasswordTextBox();
        labelInfo = new Label();

        registerButton.addClickHandler(new ClickButtonRegisterUser(labelInfo,login,password, password2));

        VerticalPanel verticalPanel = new VerticalPanel();
        verticalPanel.add(new Label("Rejestracja"));
        Grid grid = new Grid(5,2);
        grid.setWidget(0,0,labelInfo);
        grid.setWidget(1,0,new Label("Podaj login"));
        grid.setWidget(1,1, login);
        grid.setWidget(2,0,new Label("Podaj hasło"));
        grid.setWidget(2,1, password);
        grid.setWidget(3,0,new Label("Powtórz hasło"));
        grid.setWidget(3,1, password2);
        grid.setWidget(4,0,registerButton);
        verticalPanel.add(grid);
        this.add(verticalPanel);
    }


}

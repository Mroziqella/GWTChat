package pl.mroziqella.example.chat.client.view;

import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import javafx.scene.control.*;
import pl.mroziqella.example.chat.client.view.listeners.*;

import java.util.logging.*;

/**
 * Created by Kamil on 05/05/2016.
 */
public class LoginWidget extends VerticalPanel {
    final  static Logger logger = Logger.getLogger("NameOfYourLogger");
    public LoginWidget() {
        super();
        TextBox login = new TextBox();
        PasswordTextBox password = new PasswordTextBox();
        Button button = new Button("Zaloguj");
        Label errorDisplayLabel = new Label();


        Grid grid = new Grid(4,1);
        grid.setWidget(0,0,errorDisplayLabel);
        grid.setWidget(1,0,login);
        grid.setWidget(2,0,password);
        grid.setWidget(3,0,button);
        button.addClickHandler(new ClickButton(errorDisplayLabel,login,password));
        this.add(grid);

    }
}

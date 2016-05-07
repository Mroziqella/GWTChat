package pl.mroziqella.example.chat.client.view;

import com.google.gwt.user.client.*;
import com.google.gwt.user.client.ui.*;
import pl.mroziqella.example.chat.client.view.listeners.*;
import pl.mroziqella.example.chat.client.view.Timer.*;

/**
 * Created by Kamil on 04/05/2016.
 */
public class ChatWidget extends VerticalPanel {
    private TextArea allMessages;
    private TextBox message;
    private TextBox login;
    private static final int REFRESH_INTERVAL = 100;

    public ChatWidget() {
        super();
        VerticalPanel verticalPanel = new VerticalPanel();
        Grid gridBottom = new Grid(1,3);
        Grid gridTop = new Grid(1,2);
        Label messageLabel= new Label("Wiadomość: ");
        Label loginLabel= new Label("Login: ");
        Button sendButton = new Button("Wyślij");


        login = new TextBox();
        message = new TextBox();
        allMessages = new TextArea();
        allMessages.setSize("400px","200px");
        sendButton.addClickHandler(new SendButtonListener(allMessages,message, login));

        gridTop.setWidget(0,0,loginLabel);
        gridTop.setWidget(0,1,login);
        gridBottom.setWidget(0,0,messageLabel);
        gridBottom.setWidget(0,1,message);
        gridBottom.setWidget(0,2,sendButton);

        Timer refreshTimerMessages = new RefreshTimerMessages(allMessages);
        refreshTimerMessages.scheduleRepeating(REFRESH_INTERVAL);

        verticalPanel.add(gridTop);
        verticalPanel.add(allMessages);
        verticalPanel.add(gridBottom);
        this.add(verticalPanel);


    }


}

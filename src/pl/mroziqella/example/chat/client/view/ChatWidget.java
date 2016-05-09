package pl.mroziqella.example.chat.client.view;

import com.google.gwt.cell.client.*;
import com.google.gwt.dom.client.*;
import com.google.gwt.user.cellview.client.*;
import com.google.gwt.user.client.*;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.*;

import pl.mroziqella.example.chat.client.*;
import pl.mroziqella.example.chat.client.view.listeners.*;
import pl.mroziqella.example.chat.client.view.Timer.*;


/**
 * Created by Kamil on 04/05/2016.
 */
public class ChatWidget extends VerticalPanel  {
    private TextArea allMessages;
    private TextBox messageBox;
    private CellList<String> allUsersList;

    private static final int REFRESH_INTERVAL = 1000;

    public ChatWidget() {
        super();
        RootPanel.get("slot1").add(new Label("Zalogowano jako: "+Chat.getLoginSession()));
        VerticalPanel verticalPanel = new VerticalPanel();
        HorizontalPanel horizontalPanel =  new HorizontalPanel();
        Grid gridBottom = new Grid(1,4);
        Grid gridTop = new Grid(1,2);
        Label messageLabel= new Label("Wiadomość: ");


        Button sendButton = new Button("Wyślij");
        TextCell textCell = new TextCell();
        allUsersList = new CellList<String>(textCell);

        messageBox = new TextBox();
        messageBox.setSize("300px","20px");
        messageBox.getElement().setPropertyString("placeholder", "Wpisz wiadomość");
        allMessages = new TextArea();
        allMessages.setSize("400px","200px");
        sendButton.addClickHandler(new SendButtonListener(allMessages,messageBox));

        Button button =  new Button("Pokój główny");
        button.addClickHandler(new ClickButtonLogin(Chat.getLoginSession(),Chat.getPassword()));

        gridBottom.setWidget(0,0,messageLabel);
        gridBottom.setWidget(0,1,messageBox);
        gridBottom.setWidget(0,2,sendButton);
        gridBottom.setWidget(0,3,button);

        Timer refreshTimerMessages = new RefreshTimerMessages(allMessages, allUsersList);
        refreshTimerMessages.scheduleRepeating(REFRESH_INTERVAL);

        verticalPanel.add(gridTop);

        horizontalPanel.add(allMessages);
        horizontalPanel.setBorderWidth(10);
        allUsersList.setSize("50px","200px");
        horizontalPanel.add(allUsersList);
        verticalPanel.add(horizontalPanel);

        verticalPanel.add(gridBottom);

        allUsersList.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);
        SingleSelectionModel<String> selectionModel = new SingleSelectionModel<>();
        allUsersList.setSelectionModel(selectionModel);
        selectionModel.addSelectionChangeHandler(new SelectUser(selectionModel));



        this.add(verticalPanel);


    }


}

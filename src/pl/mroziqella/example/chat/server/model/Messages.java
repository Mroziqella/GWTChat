package pl.mroziqella.example.chat.server.model;


import com.google.gwt.user.client.rpc.*;

import java.util.*;
import java.util.Observable;

/**
 * Created by Kamil on 04/05/2016.
 */

public class Messages implements IsSerializable {
    private static Messages ourInstance = new Messages();
    private ArrayList<String> messages;

    private Messages() {
        messages = new ArrayList<>();
    }

    public static Messages getInstance() {
        return ourInstance;
    }

    public void addMessage(String message) {
        this.messages.add(message);
    }

    public ArrayList<String> getMessages() {

        return messages;
    }


}

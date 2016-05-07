package pl.mroziqella.example.chat.client.model;


import com.google.gwt.core.client.impl.*;
import com.google.gwt.user.client.rpc.*;

import java.util.*;
import java.util.logging.*;

/**
 * Created by Kamil on 04/05/2016.
 */

public class Messages implements IsSerializable {
    private static Messages ourInstance = new Messages();
    private LinkedList<String> messages;
    private LinkedList<String> users;
    private Messages() {
        messages = new LinkedList<>();
        users = new LinkedList<>();
    }

    public static Messages getInstance() {
        return ourInstance;
    }

    public void addMessage(String message) {
        if(messages.size()>20){
            messages.removeFirst();
        }
        this.messages.add(message);

    }


    public LinkedList<String> getMessages() {

        return messages;
    }

    public LinkedList<String> getUsers() {
        return users;
    }
    public void removeUser(String login){
        users.remove(login);
    }
    public void addUsersToList(String login){
        users.add(login);
    }
}

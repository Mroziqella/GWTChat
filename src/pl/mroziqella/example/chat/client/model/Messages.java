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
    private HashMap<String,LinkedList<String>> messages;
    private HashMap<String,HashSet<String>> users;
    private HashMap<String,String> userInfoMessage;

    private Messages() {
        messages = new HashMap<>();
        users = new HashMap<>();
        userInfoMessage =  new HashMap<>();
        users.put("all",new HashSet<String>());
        messages.put("all",new LinkedList<String>());
    }

    public static Messages getInstance() {
        return ourInstance;
    }

    public void addMessage(String roomName,String message) {
        if(messages.size()>20){
            messages.get(roomName).removeFirst();
        }
        if(messages.get(roomName)==null){
            messages.put(roomName,new LinkedList<String>());
        }
        this.messages.get(roomName).add(message);
    }


    public LinkedList<String> getMessages(String room) {

        return messages.get(room);
    }

    public HashSet<String> getUsers(String room) {
        return users.get(room);
    }
    public void removeUser(String room,String login){
        users.get(room).remove(login);
    }

    public void addUsersToList(String room,String login){
        if(users.get(room)==null){
            users.put(room,new HashSet<String>());
            String path[] = room.split(",");
            users.get(room).add(path[1]);
            userInfoMessage.put(path[1],room);
        }
        this.users.get(room).add(login);
    }
    public String isInfo(String user){
        if(userInfoMessage.containsKey(user)) {
            String tmp = userInfoMessage.get(user);
            userInfoMessage.remove(user);
            return tmp;
        }
        return null;
    }
}

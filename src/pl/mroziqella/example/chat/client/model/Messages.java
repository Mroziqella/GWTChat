package pl.mroziqella.example.chat.client.model;


import com.google.gwt.user.client.rpc.*;

import java.util.*;

/**
 * Created by Kamil on 04/05/2016.
 */

public class Messages implements IsSerializable {
    private static Messages ourInstance = new Messages();
    private HashMap<String, LinkedList<String>> messages;
    private HashMap<String, HashSet<String>> users;
    private HashMap<String, String> userInfoMessage;

    private Messages() {
        messages = new HashMap<>();
        users = new HashMap<>();
        userInfoMessage = new HashMap<>();
        users.put("all", new HashSet<String>());
        messages.put("all", new LinkedList<String>());
    }

    public static Messages getInstance() {
        return ourInstance;
    }

    public void addMessage(String roomName, String message) {
        String path[] = roomName.split(",");
        if (messages.size() > 20) {
            messages.get(roomName).removeFirst();
        }
        if (messages.get(roomName) == null) {
            if (messages.get(path[1] + "," + path[0]) == null) {
                messages.put(roomName, new LinkedList<String>());
            } else if (path.length == 2) {
                roomName = path[1] + "," + path[0];
            }
        }
        this.messages.get(roomName).add(message);
    }


    public LinkedList<String> getMessages(String room) {
        String path[] = room.split(",");
        if (path.length == 2) {
            if (messages.get(room) == null) {
                return messages.get(path[1] + "," + path[0]);
            } else {
                return messages.get(room);
            }
        } else {
            return messages.get(room);
        }
    }

    public HashSet<String> getUsers(String room) {
        String path[] = room.split(",");
        if (path.length == 2) {
            if (users.get(room) == null) {
                return users.get(path[1] + "," + path[0]);
            } else {
                return users.get(room);
            }
        } else {
            return users.get(room);
        }


    }

    public void removeUser(String room, String login) {
        try {
            users.get(room).remove(login);
        } catch (java.lang.NullPointerException e) {
        };
    }

    public void addUsersToList(String room, String login) {
        String path[] = room.split(",");
        if (users.get(room) == null) {
            if (users.get(path[1] + "," + path[0]) == null) {
                users.put(room, new HashSet<String>());
                users.get(room).add(path[1]);
            } else {
                room = path[1] + "," + path[0];
                users.get(room).add(path[1]);

            }

        }
        if (path.length == 2) {
            userInfoMessage.put(path[1], room);
        }
        this.users.get(room).add(login);
    }

    public String isInfo(String user) {
        if (userInfoMessage.containsKey(user)) {
            String tmp = userInfoMessage.get(user);
            userInfoMessage.remove(user);
            return tmp;
        }
        return null;
    }
}

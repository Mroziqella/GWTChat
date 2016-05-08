package pl.mroziqella.example.chat.server;

import com.google.gwt.user.server.rpc.*;
import pl.mroziqella.example.chat.client.*;
import pl.mroziqella.example.chat.client.Throws.*;
import pl.mroziqella.example.chat.client.model.*;
import pl.mroziqella.example.chat.server.domain.*;
import pl.mroziqella.example.chat.server.repository.*;



public class ChatServiceImpl extends RemoteServiceServlet implements ChatService {

    // Implementation of sample interface method

    public void setMessage(String roomName,String message) {
        Messages.getInstance().addMessage(roomName,message);
    }


    @Override
    public boolean userAccountExists(String roomName,String login, String password) throws InvalidPassword{
        User user = new UserRepository().getUser(login);
        if (user.getPassword().equals(password)) {
            Messages.getInstance().addUsersToList(roomName,login);
            return true;
        }
        throw new InvalidPassword("Error in login");

    }

    @Override
    public void addUser(String login, String password) {
        new UserRepository().addUser(new User(login,password));
    }

    @Override
    public Messages getMessages() {
        return Messages.getInstance();
    }

    @Override
    public void removeUserfromTheList(String roomName,String login) {
        Messages.getInstance().removeUser(roomName,login);
    }

    @Override
    public String isInfo(String login) {
        return Messages.getInstance().isInfo(login);
    }
}
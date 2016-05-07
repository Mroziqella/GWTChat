package pl.mroziqella.example.chat.server;

import com.google.gwt.user.server.rpc.*;
import pl.mroziqella.example.chat.client.*;
import pl.mroziqella.example.chat.client.Throws.*;
import pl.mroziqella.example.chat.client.model.*;
import pl.mroziqella.example.chat.server.domain.*;
import pl.mroziqella.example.chat.server.repository.*;



public class ChatServiceImpl extends RemoteServiceServlet implements ChatService {

    // Implementation of sample interface method

    public void setMessage(String message) {
        Messages.getInstance().addMessage(message);
    }

    @Override
    public boolean userAccountExists(String login, String password) throws InvalidPassword{
        User user = new UserRepository().getUser(login);
        if (user.getPassword().equals(password)) {
            Messages.getInstance().addUsersToList(login);
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
    public void removeUserfromTheList(String login) {
        Messages.getInstance().removeUser(login);
    }
}
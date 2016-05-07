package pl.mroziqella.example.chat.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pl.mroziqella.example.chat.client.Throws.*;
import pl.mroziqella.example.chat.client.model.Messages;

import java.util.*;

@RemoteServiceRelativePath("ChatService")
public interface ChatService extends RemoteService {
    // Sample interface method of remote interface
    void setMessage(String msg);

    boolean userAccountExists(String login,String password)throws InvalidPassword;
    void addUser(String login, String password);
    Messages getMessages() ;
    void removeUserfromTheList(String login);

    /**
     * Utility/Convenience class.
     * Use ChatService.App.getInstance() to access static instance of ChatServiceAsync
     */
     class App {
        private static ChatServiceAsync ourInstance = GWT.create(ChatService.class);

        public static synchronized ChatServiceAsync getInstance() {
            return ourInstance;
        }
    }
}

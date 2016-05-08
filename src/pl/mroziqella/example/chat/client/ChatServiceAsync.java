package pl.mroziqella.example.chat.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pl.mroziqella.example.chat.client.Throws.*;
import pl.mroziqella.example.chat.client.model.*;

import java.util.*;

public interface ChatServiceAsync {


    // Sample interface method of remote interface
    void setMessage(String roomName,String msg, AsyncCallback<Void> async);

    void getMessages(AsyncCallback<Messages> async);

    void userAccountExists(String roomName,String login, String password, AsyncCallback<Boolean> async) throws InvalidPassword;

    void addUser(String login, String password, AsyncCallback<Void> async);

    void removeUserfromTheList(String roomName,String login, AsyncCallback<Void> async);

    void isInfo(String login, AsyncCallback<String> async);
}

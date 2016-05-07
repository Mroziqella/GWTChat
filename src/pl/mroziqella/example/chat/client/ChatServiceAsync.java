package pl.mroziqella.example.chat.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pl.mroziqella.example.chat.server.model.*;

import java.util.*;

public interface ChatServiceAsync {


    // Sample interface method of remote interface
    void setMessage(String msg, AsyncCallback<Void> async);

    void getMessages(AsyncCallback<ArrayList<String>> async);

    void userAccountExists(String login, String password, AsyncCallback<Boolean> async);
}

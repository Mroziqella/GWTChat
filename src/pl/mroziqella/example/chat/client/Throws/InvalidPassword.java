package pl.mroziqella.example.chat.client.Throws;

import com.google.gwt.user.client.rpc.*;

import java.rmi.*;

/**
 * Created by Kamil on 05/05/2016.
 */
public class InvalidPassword extends RuntimeException implements IsSerializable {
    public InvalidPassword() {
        super("Access error");
    }
    public InvalidPassword(String s) {
        super(s);
    }


}

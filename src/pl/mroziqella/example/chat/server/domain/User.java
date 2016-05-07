package pl.mroziqella.example.chat.server.domain;

import com.google.gwt.user.client.rpc.*;
import org.hibernate.validator.constraints.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.*;

/**
 * Created by Kamil on 25/03/2016.
 */
@Entity
@Table(name="uzytkownik")
public class User implements Serializable{
    @Id
    private String login;

    private String password;
    private String password2;

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return null;
    }


}

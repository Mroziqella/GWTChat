package pl.mroziqella.example.chat.server;

import com.google.gwt.user.server.rpc.*;
import pl.mroziqella.example.chat.client.*;
import pl.mroziqella.example.chat.server.model.*;
import pl.mroziqella.example.chat.server.domain.*;

import javax.persistence.*;
import java.util.*;
import java.util.logging.*;


public class ChatServiceImpl extends RemoteServiceServlet implements ChatService {
    private static Logger logger = Logger.getLogger("Test: 111111111111111111111111111111111111111111111111");

    // Implementation of sample interface method

    public void setMessage(String message) {
        Messages.getInstance().addMessage(message);
    }

    @Override
    public boolean userAccountExists(String login, String password) {
        logger.info(login);
        User user;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        user = entityManager.find(User.class, login);
        logger.info(user.getLogin());

        entityManager.getTransaction().commit();


        entityManager.close();
        entityManagerFactory.close();
        if (user.getPassword().equals(password)) {
            return true;
        }
        return false;

    }

    @Override
    public ArrayList<String> getMessages() {
        return Messages.getInstance().getMessages();
    }
}
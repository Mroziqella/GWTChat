package pl.mroziqella.example.chat.server.repository;

import pl.mroziqella.example.chat.server.domain.*;

import javax.persistence.*;

/**
 * Created by Kamil on 07/05/2016.
 */
public class UserRepository {
    private  EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public User getUser(String login) {
        try {
             entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
             entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            User  user = entityManager.find(User.class, login);

            entityManager.getTransaction().commit();

            return user;
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }
    public void addUser(User user){

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(user);

            entityManager.getTransaction().commit();

        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}

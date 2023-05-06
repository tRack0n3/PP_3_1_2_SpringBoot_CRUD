package com.vn.web.dao;


import com.vn.web.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.*;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return  entityManager.createQuery("SELECT u from User u", User.class).getResultList();
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void deleteUser(Long id) {
        User user = getUser(id);
        entityManager.remove(user);
        entityManager.flush();
    }

    @Override
    public void updateUser(User updatedUser) {
//        User userToBeUpdated = getUser(id);
        entityManager.merge(updatedUser);
        entityManager.flush();
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }
}

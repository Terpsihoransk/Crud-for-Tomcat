package web.Dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;


@Component
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getManager () {
        return this.entityManager;
    }


    @Override
    public List<User> getAllUsers() {
        return getManager().createQuery("SELECT u from User u", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return getManager().find(User.class, id);
    }

    @Override
    public void addUser(User user) {
        getManager().persist(user);
    }

    @Override
    public void removeUser(int id) {
        getManager().remove(getUserById(id));
    }

//    @Override
//    public void removeUser(int id) {
//        entityManager.createQuery("delete from User u where u.id=:id").setParameter("id", id).executeUpdate();
//    }

    @Override
    public void updateUser(int id, User user) {
        getManager().merge(user);
    }
}









/*
@Repository
public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {}

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User saveUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.createQuery("delete from User where id=:id").setParameter("id", id).executeUpdate();
    }

    @Override
    public User updateUser(User user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    public User getUser(Long id) {
       return entityManager.find(User.class, id);
    }

    @Override
    public List<User> allUser() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }
}

*/
package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addUser(User user) {
        this.entityManager.persist(user);
    }


    @Override
    public void deleteUser(long id) {
        entityManager.createQuery("delete from User where id= :id").setParameter("id", (int) id).executeUpdate();
    }

    @Override
    public User getUser(long id) {
        User user = entityManager.find(User.class, (int) id);
        return user;

    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<User> getAllUsers(){
        return entityManager.createQuery("FROM User").getResultList();
    }
}

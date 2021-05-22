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
    @Transactional
    public void addUser(User user) {
        this.entityManager.persist(user);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        User user = entityManager.find(User.class, (int) id);
        entityManager.remove(user);

    }

    @Override
    @Transactional
    public void updateUser(long id, String name, String surname, String mail, int age) {
        User user = entityManager.find(User.class, (int) id);
        user.setName(name);
        user.setSurname(surname);
        user.setMail(mail);
        user.setAge(age);
    }

    @Override
    @Transactional
    public List<User> getAllUsers(){
        return entityManager.createQuery("FROM User").getResultList();
    }
}

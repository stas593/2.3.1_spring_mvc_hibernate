package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Role;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.From;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addRole(Role role) {
        this.entityManager.persist(role);
    }

    @Override
    public Role getRole(long id) {
        Role role = entityManager.find(Role.class, id);
        return role;
    }

    @Override
    public Role getRoleByName(String roleName) {
        return (Role) entityManager.createQuery("FROM Role where role = :roleName").setParameter("roleName", roleName)
                .getSingleResult();
    }

    @Override
    public void deleteRole(long id) {
        entityManager.createQuery("delete from Role where id= :id").setParameter("id", (int) id).executeUpdate();
    }

    @Override
    public void updateRole(Role role) {
        entityManager.createQuery("update Role set nameRole = :role where id = :id")
                .setParameter("role", role.getNameRole())
                .setParameter("id",  role.getId())
                .executeUpdate();
    }

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("FROM Role", Role.class).getResultList();
    }
}

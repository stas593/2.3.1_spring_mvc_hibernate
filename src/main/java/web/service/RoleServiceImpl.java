package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dao.RoleDao;
import web.models.Role;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Component
public class RoleServiceImpl implements RoleService {

    @Autowired
    public RoleDao roleDao;

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    public Role getRole(long id) {
        return roleDao.getRole(id);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName);
    }

    @Override
    public void deleteRole(long id) {
        roleDao.deleteRole(id);
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    @Transactional
    public Set<Role> getAllRolesFromUser(long userId) {
        return roleDao.getAllRolesFromUser(userId);
    }
}

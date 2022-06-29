package web.service;

import web.dao.RoleDao;
import web.model.Role;

import java.util.List;

public class RoleServiceImpl implements RoleService{

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role getByName(String name) {
        return roleDao.getByName(name);
    }

    @Override
    public List<Role> getAll() {
        return roleDao.getAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role getById(Long id) {
        return roleDao.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        roleDao.deleteById(id);
    }

    @Override
    public void update(Role role) {
        roleDao.update(role);
    }
}

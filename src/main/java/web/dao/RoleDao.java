package web.dao;

import web.model.Role;

import java.util.List;

public interface RoleDao {
    public void save(Role role);

    public Role findById(Long id);

    public Role findByName(String name);

    public List<Role> findAll();

    public void deleteById(Long id);

    public void update(Role role);
}

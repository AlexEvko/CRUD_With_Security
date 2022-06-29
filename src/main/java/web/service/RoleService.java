package web.service;

import web.model.Role;

import java.util.List;

public interface RoleService {
    public Role getByName(String name);

    public List<Role> getAll();

    public void save(Role role);

    public Role getById(Long id);

    public void deleteById(Long id);

    public void update(Role role);
}

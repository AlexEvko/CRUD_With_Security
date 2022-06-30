package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public void save(User user);

    public User findById(Long id);

    public User findByName(String name);

    public List<User> findAll();

    public void deleteById(Long id);

    public void update(User user);
}

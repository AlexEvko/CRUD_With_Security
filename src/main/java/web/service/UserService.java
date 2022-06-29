package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public User getUserByName(String name);

    public List<User> getAll();

    public void saveUser(User user);

    public User getById(Long id);

    public void deleteById(Long id);

    public void update(User user);
}

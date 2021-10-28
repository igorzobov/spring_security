package app.service;

import app.model.User;

import java.util.List;

public interface UserService {
    public List<User> getUserList();

    public User show(long id);

    public void save(User user);

    public void update(User user);

    public void delete(long id);

    User getUserByName(String s);
}

package app.dao;

import app.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserDao {
    public List<User> getUserList();
    public User show(long id);
    public void save(User user);
    public void update(long id, User user);
    public void delete(long id);

    UserDetails getUserByName(String s);
}

package app.UserDao;

import app.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    private static long ID;
    List<User> userList;
    {
        userList = new ArrayList<>();
        userList.add(new User(++ID, "Igor", 33, "igor_zobov@mail.ru"));
        userList.add(new User(++ID, "Egor", 20, "email@egor.com"));
        userList.add(new User(++ID, "Ivor", 45, "ivor@mail.ru"));
    }

    public List<User> getUserList() {
        return userList;
    }

    public User show(long id) {
        return userList.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public void save(User user) {
        user.setId(++ID);
        userList.add(user);
    }

    public void update(long id, User updatedUser) {
        User userToBeUpdated = show(id);

        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setAge(updatedUser.getAge());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    public void delete(long id) {
        userList.removeIf(u -> u.getId() == id);
    }
}

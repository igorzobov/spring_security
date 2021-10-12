package app.UserDao;

import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
//@PropertySource("classpath:db.properties")
public class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getUserList() {
        return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<>(User.class));
    }

    public User show(long id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(User.class))
                .stream().findFirst().orElse(null);
    }

    public void save(User user) {
        jdbcTemplate.update("INSERT INTO users VALUES (1, ?, ?, ?)",
                user.getName(), user.getAge(), user.getEmail());
    }

    public void update(long id, User updatedUser) {
        jdbcTemplate.update("UPDATE users SET name=?, age=?, email=? WHERE id=?",
                updatedUser.getName(), updatedUser.getAge(), updatedUser.getEmail(), id);
    }

    public void delete(long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
    }
}

package app.dao;

import app.model.Role;

import java.util.List;

public interface RoleDao {
    void addRole(Role role);

    List<Role> getAllRoles();

    Role getRoleByName(String name);
}

package app.dao;

import app.model.Role;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void updateRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void removeRoleById(long id) {
        entityManager.remove(entityManager.find(Role.class, id));
    }

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("FROM Role").getResultList();
    }

    @Override
    public Role getRoleByName(String name) {
        TypedQuery<Role> queryRole = entityManager.createQuery("select r from Role r where r.rolename=:role",
                Role.class).setParameter("role", name);
        return queryRole.getSingleResult();
    }
}

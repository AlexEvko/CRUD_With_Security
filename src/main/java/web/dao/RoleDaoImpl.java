package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Role getByName(String name) {
        return entityManager.createQuery("SELECT role FROM Role role WHERE role.name = : role", Role.class)
                .setParameter("role", name)
                .getSingleResult();
    }

    @Override
    public List<Role> getAll() {
        return entityManager.createQuery("SELECT roles FROM Role roles", Role.class).getResultList();
    }

    @Override
    public void save(Role role) {
        entityManager.persist(role);
    }

    @Override
    public Role getById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public void deleteById(Long id) {
        entityManager.createQuery("DELETE FROM Role role WHERE role.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void update(Role role) {
        entityManager.merge(role);
    }
}

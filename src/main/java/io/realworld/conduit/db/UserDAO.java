package io.realworld.conduit.db;

import io.dropwizard.hibernate.AbstractDAO;
import io.realworld.conduit.core.User;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class UserDAO extends AbstractDAO<User> {
    public UserDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(get(id));
    }

    public User create(User user) {
        return persist(user);
    }

    public List<User> findAll() {
        return list(namedQuery("io.realworld.conduit.core.User.findAll"));
    }
}

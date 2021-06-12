package ug.ite2200.chatapp.repositories;

import org.sql2o.Sql2o;
import ug.ite2200.chatapp.daos.UserDAO;
import ug.ite2200.chatapp.entities.User;

import java.util.List;
import java.util.UUID;

/**
 * @author amritaramnauth
 */
public class UserRepository implements Repository<User>{

    private Sql2o db;
    private UserDAO dao;

    public UserRepository(Sql2o db) {
        dao = new UserDAO(db);
    }


    @Override
    public User get(UUID id) {
        return dao.get(id);
    }

    @Override
    public List<User> findAll() {
        return dao.list();
    }

    @Override
    public void add(User user) {
        dao.create(user);
    }

    @Override
    public void delete(UUID id) {
        return;
    }
}

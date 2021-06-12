package ug.ite2200.chatapp.daos;

import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import ug.ite2200.chatapp.entities.User;

import java.util.List;
import java.util.UUID;

public class UserDAO {

    private Sql2o db;

    public final static String CREATE_USER =
            "INSERT INTO users(email, contact_number, address, username, user_type, age, gender, hobbies, characteristics)"
                    + " VALUES (:email, :contact_number, :address, :username, :user_type, :age, :gender, :hobbies, :characteristics)";
    public final static String READ_USERS = "SELECT * FROM users";
    public final static String READ_USER = "SELECT * FROM users WHERE id = :id";

    public UserDAO(Sql2o db) {
        this.db = db;
    }

    public void create(User user) {
        try(Connection con = db.open()) {
            Query query = con.createQuery(CREATE_USER, true).bind(user);
            Connection connection = query.executeUpdate();
        }
    }

    public User get(UUID id) {
        try(Connection conn = db.open()) {
            Query query = conn.createQuery(READ_USER).addParameter("id", id);
            User user = query.executeAndFetchFirst(User.class);
            return user;
        }
    }

    public List<User> list() {
        try(Connection conn = db.open()) {
            Query query = conn.createQuery(READ_USERS);
            List<User> users = query.executeAndFetch(User.class);
            return users;
        }
    }
}

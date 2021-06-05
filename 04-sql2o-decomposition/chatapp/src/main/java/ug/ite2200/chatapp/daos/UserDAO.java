package ug.ite2200.chatapp.daos;

import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import ug.ite2200.chatapp.entities.Business;
import ug.ite2200.chatapp.entities.Person;

public class UserDAO {

    private Sql2o db;

    public final static String CREATE_PERSON_USER =
            "INSERT INTO users(email, contact_number, address, name, age, gender, hobbies)"
                    + " VALUES (:email, :contact_number, :address, :name, :age, :gender, :hobbies)";
    public final static String CREATE_BUSINESS_USER =
            "INSERT INTO users(email, contact_number, address, name, characteristics)"
                    + " VALUES (:email, :contact_number, :address, :name, :characteristics)";
    public final static String LIST_USERS = "SELECT * FROM users";
    public final static String GET_USERS = "SELECT * FROM users WHERE id = :id";
    public final static String REMOVE_USER = "DELETE FROM users WHERE id = :id";

    public UserDAO(Sql2o db) {
        this.db = db;
    }

    public int create(Person person) {
        try(Connection con = db.open()) {
            Query query = con.createQuery(CREATE_PERSON_USER, true).bind(person);
            Connection connection = query.executeUpdate();

            int id = (int) connection.getKey();
            return id;
        }
    }

    public int create(Business business) {
        try(Connection con = db.open()) {
            Query query = con.createQuery(CREATE_BUSINESS_USER, true).bind(business);
            Connection connection = query.executeUpdate();

            int id = (int) connection.getKey();
            return id;
        }
    }

    public Sql2o getDb() {
        return db;
    }

    public void setDb(Sql2o db) {
        this.db = db;
    }
}

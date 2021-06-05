package ug.ite2200.chatapp;

import org.sql2o.Sql2o;
import ug.ite2200.chatapp.daos.UserDAO;
import ug.ite2200.chatapp.entities.Business;
import ug.ite2200.chatapp.entities.Person;

public class ChatApp {

    public ChatApp() {

    }
    public void run() {
        // initialize connection to database
        Sql2o db = new Sql2o("jdbc:postgresql://postgres:5432/chatapp", "postgres", "postgres");

        UserDAO userDAO = new UserDAO(db);

        // person user
        Person user1 = new Person("johndoe@email.com", "666-0987", "Lot 12 Queenstown",
                "John Doe", 23, "Male", "reading, programming");

        // business user
        Business user2 = new Business("business@email.com", "223-2122", "Lot 12 New Business address",
                "XYZ Business", "modern, computing, small-business");

        // create users, return created ids
        System.out.println(userDAO.create(user1));
        System.out.println(userDAO.create(user2));

    }

}

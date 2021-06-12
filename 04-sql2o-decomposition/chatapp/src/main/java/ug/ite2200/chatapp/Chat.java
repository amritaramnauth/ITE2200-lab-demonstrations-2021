package ug.ite2200.chatapp;

import org.sql2o.Sql2o;
import ug.ite2200.chatapp.entities.User;

public class Chat {

    public void run() {

        Sql2o db = new Sql2o("jdbc:postgresql://postgres:5432/chat", "postgres", "postgres");

        // users
        User user1 = new User("jane@email.com", "666-0987", "123 King Street",
                "janedoe", 23, "Female", "mountain-climbing, running");

        User user2 = new User("campus-queries@uog.edu.gy", "222-7896", "Turkeyen",
                "uog", "tertiary, education, university");

    }

}

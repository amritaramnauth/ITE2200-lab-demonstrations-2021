package ug.ite2200.chatapp;

import org.sql2o.Sql2o;
import ug.ite2200.chatapp.entities.Room;
import ug.ite2200.chatapp.entities.User;
import ug.ite2200.chatapp.repositories.RoomRepository;
import ug.ite2200.chatapp.repositories.UserRepository;
import ug.ite2200.chatapp.services.RoomService;

import java.util.UUID;

public class Chat {

    public void run() {

        Sql2o db = new Sql2o("jdbc:postgresql://postgres:5432/chat", "postgres", "postgres");
        UserRepository userRepository = new UserRepository(db);
        RoomRepository roomRepository = new RoomRepository(db);
        RoomService roomService = new RoomService(db);

        // users
        User user1 = new User("edu@uog.edu.gy", "333-3333", "123 Turkeyen",
                "universityofguyana", "tertiary, education, university");


        Room room1 = new Room("university tips");

        User universityofguyana = userRepository.get(UUID.fromString("0310eb87-1173-4ab5-b4f0-45d55dc62d36"));
        Room tips = roomRepository.get(UUID.fromString("f18f45dd-27e7-4de5-a548-16c3219563d0"));

        // create user
//        userRepository.add(user1);

        // create rooom
//        roomRepository.add(room1);

        // join room
//        try {
//            roomService.joinRoom(universityofguyana, tips);
//        } catch (Exception e) {
//            System.out.println(e);
//        }

        try {
            roomService.removeFromRoom(universityofguyana, tips);
        } catch (Exception e) {
            System.out.println(e);
        }


    }

}

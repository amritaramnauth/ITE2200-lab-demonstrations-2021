package ug.ite2200.chatapp.services;

import org.sql2o.Sql2o;
import ug.ite2200.chatapp.entities.Room;
import ug.ite2200.chatapp.entities.RoomUser;
import ug.ite2200.chatapp.entities.User;
import ug.ite2200.chatapp.repositories.RoomRepository;
import ug.ite2200.chatapp.repositories.UserRepository;

/**
 * @author amritaramnauth
 */
public class RoomService {

    private Sql2o db;
    private RoomRepository roomRepository;
    private UserRepository userRepository;

    public RoomService(Sql2o db) {
        this.roomRepository = new RoomRepository(db);
        this.userRepository = new UserRepository(db);
    }

    public void joinRoom(User user, Room room) throws Exception {

        // check for existing user and room
        User existingUser = userRepository.get(user.getId());
        Room existingRoom = roomRepository.get(room.getId());

        RoomUser roomUser;
        if (existingUser != null && existingRoom != null) {
            // check if user is part of room
            roomUser = roomRepository.getByRoomUser(existingRoom, existingUser);
        } else throw new Exception("User or room doesn't exist");

        if (roomUser == null) {
            roomRepository.addRoomUser(existingRoom, existingUser);
            System.out.println(existingUser.getUsername() + " joined room: " + existingRoom.getName() + " successfully");
        } else throw  new Exception("User already joined room");
    }

    public void removeFromRoom(User user, Room room) throws Exception {

        // check for existing user and room
        User existingUser = userRepository.get(user.getId());
        Room existingRoom = roomRepository.get(room.getId());

        RoomUser roomUser;
        if (existingUser != null && existingRoom != null) {
            // check if user is part of room
            roomUser = roomRepository.getByRoomUser(existingRoom, existingUser);
        } else throw new Exception("User or room doesn't exist");

        if (roomUser != null) {
            roomRepository.deleteRoomUser(roomUser.getId());
            System.out.println(existingUser.getUsername() + " was removed from room: " + existingRoom.getName() + " successfully");
        } else throw  new Exception("User is not in room");

    }


}

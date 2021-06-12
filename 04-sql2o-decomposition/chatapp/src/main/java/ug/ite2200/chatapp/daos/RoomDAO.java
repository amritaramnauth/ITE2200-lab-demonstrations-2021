package ug.ite2200.chatapp.daos;

import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import ug.ite2200.chatapp.entities.Room;
import ug.ite2200.chatapp.entities.RoomUser;
import ug.ite2200.chatapp.entities.User;

import java.util.List;
import java.util.UUID;

/**
 * @author amritaramnauth
 */
public class RoomDAO {

    private Sql2o db;

    public final static String CREATE_ROOM =
            "INSERT INTO rooms(name)"
                    + " VALUES (:name)";
    public final static String READ_ROOMS = "SELECT * FROM rooms";
    public final static String READ_ROOM = "SELECT * FROM rooms WHERE id = :id";
    public final static String CREATE_ROOM_USER =
            "INSERT INTO room_users(room_id, user_id)"
                    + " VALUES (:room_id, :user_id)";
    public final static String READ_ROOM_USERS = "SELECT * FROM room_users WHERE room_id = :room_id";
    public final static String READ_ROOM_USER = "SELECT * FROM room_users WHERE room_id = :room_id AND user_id = :user_id";
    public final static String DELETE_ROOM_USER = "DELETE FROM room_users WHERE id = :id";

    public RoomDAO(Sql2o db) {
        this.db = db;
    }

    public void create(Room room) {
        try(Connection con = db.open()) {
            Query query = con.createQuery(CREATE_ROOM, true).bind(room);
            Connection connection = query.executeUpdate();
        }
    }

    public Room get(UUID id) {
        try(Connection conn = db.open()) {
            Query query = conn.createQuery(READ_ROOM).addParameter("id", id);
            Room room = query.executeAndFetchFirst(Room.class);
            return room;
        }
    }

    public List<Room> list() {
        try(Connection conn = db.open()) {
            Query query = conn.createQuery(READ_ROOMS);
            List<Room> rooms = query.executeAndFetch(Room.class);
            return rooms;
        }
    }

    public void createRoomUser(Room room, User user) {
        try(Connection con = db.open()) {
            Query query = con.createQuery(CREATE_ROOM_USER, true)
                    .addParameter("room_id", room.getId())
                    .addParameter("user_id", user.getId());
            Connection connection = query.executeUpdate();
        }
    }
    public RoomUser getRoomUser(Room room, User user) {
        try(Connection conn = db.open()) {
            Query query = conn.createQuery(READ_ROOM_USER)
                    .addParameter("room_id", room.getId())
                    .addParameter("user_id", user.getId());
            RoomUser roomUser = query.executeAndFetchFirst(RoomUser.class);
            return roomUser;
        }
    }

    public void deleteRoomUser(UUID id) {
        try(Connection conn = db.open()) {
            Query query = conn.createQuery(DELETE_ROOM_USER).addParameter("id", id);
            Connection connection = query.executeUpdate();
        }
    }


}

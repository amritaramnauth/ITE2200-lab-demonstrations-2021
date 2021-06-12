package ug.ite2200.chatapp.repositories;

import org.sql2o.Sql2o;
import ug.ite2200.chatapp.daos.RoomDAO;
import ug.ite2200.chatapp.entities.Room;
import ug.ite2200.chatapp.entities.RoomUser;
import ug.ite2200.chatapp.entities.User;

import java.util.List;
import java.util.UUID;

/**
 * @author amritaramnauth
 */
public class RoomRepository implements Repository<Room>{

    private Sql2o db;
    private RoomDAO dao;

    public RoomRepository(Sql2o db) {
        dao = new RoomDAO(db);
    }

    @Override
    public Room get(UUID id) {
        return dao.get(id);
    }

    @Override
    public List<Room> findAll() {
        return dao.list();
    }

    @Override
    public void add(Room room) {
        dao.create(room);
    }

    @Override
    public void delete(UUID id) {
        return;
    }

    public void addRoomUser(Room room, User user) {
        dao.createRoomUser(room, user);
    }

    public RoomUser getByRoomUser(Room room, User user) {
       return dao.getRoomUser(room, user);
    }

    public void deleteRoomUser(UUID id) {
        dao.deleteRoomUser(id);
    }
}

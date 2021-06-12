package ug.ite2200.chatapp.entities;

import java.util.UUID;

/**
 * @author amritaramnauth
 */
public class RoomUser {

    private UUID id;
    private UUID room_id;
    private UUID user_id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getRoom_id() {
        return room_id;
    }

    public void setRoom_id(UUID room_id) {
        this.room_id = room_id;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }
}

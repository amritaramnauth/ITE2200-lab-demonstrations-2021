package ug.ite2200.chatapp.entities;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author amritaramnauth
 */
public class Message {

    private UUID id;
    private UUID sender_id;
    private UUID room_id;
    private String content;
    private String type;
    private String created_at;

    public Message(UUID sender_id, UUID room_id, String content) {
        this.sender_id = sender_id;
        this.room_id = room_id;
        this.content = content;
        this.type = "MULTIMEDIA";
        this.created_at = LocalDateTime.now().toString();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getSender_id() {
        return sender_id;
    }

    public void setSender_id(UUID sender_id) {
        this.sender_id = sender_id;
    }

    public UUID getRoom_id() {
        return room_id;
    }

    public void setRoom_id(UUID room_id) {
        this.room_id = room_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sender_id=" + sender_id +
                ", room_id=" + room_id +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}

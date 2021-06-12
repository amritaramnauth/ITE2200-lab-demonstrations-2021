package ug.ite2200.chatapp.daos;

import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import ug.ite2200.chatapp.entities.Message;

import java.util.List;
import java.util.UUID;

/**
 * @author amritaramnauth
 */
public class MessageDAO {

    private Sql2o db;

    public final static String CREATE_MESSAGE =
            "INSERT INTO messages(sender_id, room_id, content, type, created_at)"
                    + " VALUES (:sender_id, :room_id, :content, :type, :created_at)";
    public final static String READ_MESSAGES = "SELECT * FROM messages WHERE room_id = :room_id ORDER by created_at";
    public final static String READ_MESSAGE = "SELECT * FROM messages WHERE id = :id";
    public final static String SEARCH_MESSAGES = "SELECT * FROM messages WHERE room_id = :room_id AND content LIKE :content";
    public final static String DELETE_MESSAGE = "DELETE FROM messages WHERE id = :id";


    public MessageDAO(Sql2o db) {
        this.db = db;
    }

    public List<Message> search(UUID id, String searchTerm) {
        try (Connection conn = db.open()) {
            Query query = conn.createQuery(SEARCH_MESSAGES)
                    .addParameter("room_id", id)
                    .addParameter("content", "%"+searchTerm+"%");
            List<Message> messages = query.executeAndFetch(Message.class);
            return messages;
        }
    }


}

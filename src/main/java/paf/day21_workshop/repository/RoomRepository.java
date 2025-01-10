package paf.day21_workshop.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import paf.day21_workshop.model.Room;
import paf.day21_workshop.utils.sql;

@Repository
public class RoomRepository {

    @Autowired 
    private JdbcTemplate template;

    // paf day 21 - slides 26 / 27
    public List<Room> getRooms() {
        List<Room> rooms = new LinkedList<>();
        SqlRowSet sqlRowSet = template.queryForRowSet(sql.getAllRooms);
        while(sqlRowSet.next()) {
            Room rm = new Room(sqlRowSet.getInt("id"), sqlRowSet.getString("room_type"), 
                sqlRowSet.getFloat("price"));
            rooms.add(rm);
        }
        return rooms;
    }

    public Room getRoomById(int id) {
        SqlRowSet rs = template.queryForRowSet(sql.getRoomById, id);
        Room rm = new Room();
        while(rs.next()) {
            rm.setId(id);
            rm.setRoomtype(rs.getString("room_type"));
            rm.setPrice(rs.getFloat("price"));
        }
        return rm;
    }

    public boolean deleteRoomById(int id) {
        int roomDeleted = template.update(sql.deleteRoomById, id);
        if(roomDeleted > 0)
            return true;
        return false;
    }

    public boolean updateRoomById(Room room, int id) {
        int roomUpdated = template.update(sql.updateCustomerById, room.getRoomtype(), 
            room.getPrice(), id);
        if(roomUpdated > 0)
            return true;
        return false;
    }

    public boolean insertNewRoom(Room room) {
        int roomCreated = template.update(sql.insertRoom, room.getRoomtype(), room.getPrice());
        if(roomCreated > 0) {
            return true;
        }
        return false;
    }


    
}

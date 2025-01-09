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
    
}

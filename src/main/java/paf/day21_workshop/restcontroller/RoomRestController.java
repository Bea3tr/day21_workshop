package paf.day21_workshop.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import paf.day21_workshop.model.Room;
import paf.day21_workshop.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomRestController {
    
    @Autowired
    private RoomService roomSvc;

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomSvc.getAllRooms();
        return ResponseEntity.ok().body(rooms);
    }
}

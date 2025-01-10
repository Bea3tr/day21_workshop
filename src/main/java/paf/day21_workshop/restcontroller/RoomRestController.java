package paf.day21_workshop.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import paf.day21_workshop.model.Room;
import paf.day21_workshop.model.exception.ResourceNotFoundException;
import paf.day21_workshop.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomRestController {
    
    @Autowired
    private RoomService roomSvc;

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomSvc.getAllRooms();
        if(rooms.isEmpty())
            throw new ResourceNotFoundException("No record found in room table");
        return ResponseEntity.ok().body(rooms);
    }

     @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(roomSvc.getRoomById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteRoomById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(roomSvc.deleteRoomById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateRoomById(@PathVariable Integer id,
        @RequestBody Room room) {
        
        // Check existing customer
        // Customer c = custSvc.getCustomerById(id);
        // boolean customerUpdated = false;
        // if(c != null)
        //     customerUpdated = custSvc.updateCustomerById(customer, id);
        return ResponseEntity.ok().body(roomSvc.updateRoomById(room, id));
    }

     @PostMapping
    public ResponseEntity<Boolean> insertNewRoom(@RequestBody Room room) {
        boolean roomCreated = roomSvc.insertNewRoom(room);
        return ResponseEntity.ok().body(roomCreated);
    }
}


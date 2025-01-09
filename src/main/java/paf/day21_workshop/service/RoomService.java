package paf.day21_workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paf.day21_workshop.model.Room;
import paf.day21_workshop.repository.RoomRepository;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepo;

    public List<Room> getAllRooms() {
        return roomRepo.getRooms();
    }
    
}

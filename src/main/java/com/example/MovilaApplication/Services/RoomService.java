package com.example.MovilaApplication.Services;

import com.example.MovilaApplication.Models.Room;
import com.example.MovilaApplication.Models.ResponseObject;
import com.example.MovilaApplication.Repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    // Post
    public Room addRoom(Room room){
        return roomRepository.save(room);
    }
    // Get
    public Optional<Room> findRoomByID(long id){
        Optional<Room> optionalRoom = roomRepository.findById(id);
        return optionalRoom;
    }
    // Put
    @Transactional
    public Optional<Room> updateRoom(Room newRoom, Long id){
        boolean exists = roomRepository.existsById(id);
        if(exists) {
            Optional<Room> updateRoom = roomRepository.findById(id)
                    .map(room -> {
                        room.setName(newRoom.getName());
                        room.setCid(newRoom.getCid());
                        room.setPrice(newRoom.getPrice());
                        room.setNumberOfGuest(newRoom.getNumberOfGuest());
                        room.setFloor(newRoom.getFloor());
                        room.setArea(newRoom.getArea());
                        room.setWifi(newRoom.getWifi());
                        room.setView(newRoom.getView());
                        room.setDescription(newRoom.getDescription());

                        return roomRepository.save(room);
                    });
            return updateRoom;
        }
        return null;
    }
    // Delete
    public Boolean deleteRoom(Long id) {
        boolean exists = roomRepository.existsById(id);
        if(!exists){
            return false;
        }
        else{
            roomRepository.deleteById(id);
            return true;
        }
    }

    public List<Room> getAllRooms() {
        List<Room> roomList = roomRepository.findAll();
        return  roomList;
    }
}

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
    public ResponseEntity<ResponseObject> addRoom(Room room){
        return  ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("200", "Add room successfully", roomRepository.save(room))
        );
    }
    // Get
    public ResponseEntity<ResponseObject> findRoomByID(long id){
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if(optionalRoom.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("200", "Get room detail successfully", optionalRoom)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("404", "Cannot found this room by Id: " + id, "")
            );
        }
    }
    // Put
    @Transactional
    public ResponseEntity<ResponseObject> updateRoom(Room newRoom, Long id){
        boolean exists = roomRepository.existsById(id);
        if(!exists){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("404", "Cannot found this room by Id: " + id, "")
            );
        }
        else {
            Optional<Room> updateRoom = roomRepository.findById(id)
                    .map(room -> {
                        room.setName(newRoom.getName());
                        room.setCat(newRoom.getCat());
                        room.setPrice(newRoom.getPrice());
                        room.setNumberOfGuest(newRoom.getNumberOfGuest());
                        room.setFloor(newRoom.getFloor());
                        room.setArea(newRoom.getArea());
                        room.setWifi(newRoom.getWifi());
                        room.setView(newRoom.getView());
                        room.setDescription(newRoom.getDescription());

                        return roomRepository.save(room);
                    });
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("200", "Update room successfully", updateRoom)
            );
        }
    }
    // Delete
    public ResponseEntity<ResponseObject> deleteRoom(Long id) {
        boolean exists = roomRepository.existsById(id);
        if(!exists){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("404", "Cannot found this room by Id: " + id, "")
            );
        }
        else{
            roomRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("200", "Delete room by Id: " + id + "successfully", "")
            );
        }
    }

    public ResponseEntity<ResponseObject> getAllRooms() {
        List<Room> roomList = roomRepository.findAll();
        if (roomList.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("200", "Get all user successfully", roomList)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("404", "Cannot found any user", "")
            );
        }
    }
}

package com.example.MovilaApplication.Controllers;

import com.example.MovilaApplication.Models.Hotel;
import com.example.MovilaApplication.Models.Room;
import com.example.MovilaApplication.Models.ResponseObject;
import com.example.MovilaApplication.Repositories.HotelRepository;
import com.example.MovilaApplication.Repositories.RoomRepository;
import com.example.MovilaApplication.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/rooms")
public class RoomController {
    @Autowired
    RoomService roomService;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    HotelRepository hotelRepository;

    @GetMapping
    public ResponseEntity<ResponseObject> getAllRooms(){
        return roomService.getAllRooms();
    }
    @GetMapping(path="{id}")
    public ResponseEntity<ResponseObject> findRoomByID(@PathVariable long id) {
        return roomService.findRoomByID(id);
    }
    @PostMapping
    public ResponseEntity<ResponseObject> addRoom(@RequestBody Room room){
        return roomService.addRoom(room);
    }
    @PutMapping(path="{id}")
    public ResponseEntity<ResponseObject> updateRoom(@PathVariable("id") Long id,  @RequestBody Room newRoom){
        return roomService.updateRoom(newRoom, id);
    }
    @PutMapping("/{rid}/hotels/{hid}")
    public Room assignToHotel(@PathVariable Long rid, @PathVariable Long hid) {
        Room room = roomRepository.findById(rid).get();
        Hotel hotel = hotelRepository.findById(hid).get();
        room.setHotel(hotel);
        return roomRepository.save(room);
    }
    @DeleteMapping(path="{id}")
    public ResponseEntity<ResponseObject> deleteRoom(@PathVariable("id") Long id){
        return roomService.deleteRoom(id);
    }
}

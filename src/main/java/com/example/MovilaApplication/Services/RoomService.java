package com.example.MovilaApplication.Services;

import com.example.MovilaApplication.Models.Hotel;
import com.example.MovilaApplication.Models.Room;
import com.example.MovilaApplication.Repositories.HotelRepository;
import com.example.MovilaApplication.Repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;

    @Autowired
    HotelRepository hotelRepository;
    // Get
    public List<Optional<Room>> findRoomByID(long id){
        Optional<Room> optionalRoom = roomRepository.findById(id);
        List<Optional<Room>> listRooms = new ArrayList<>();
        listRooms.add(optionalRoom);
        return listRooms;
    }

    // Post
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    // Put
    @Transactional
    public Optional<Room> updateRoom(Room newRoom, Long id){
        boolean exists = roomRepository.existsById(id);
        if(exists) {
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
        return roomList;
    }

    public Room addRoomAtHotel(Room room, Long hid) {
        Hotel hotel = hotelRepository.findById(hid).get();
        room.setHotel(hotel);
        return roomRepository.save(room);
    }
}

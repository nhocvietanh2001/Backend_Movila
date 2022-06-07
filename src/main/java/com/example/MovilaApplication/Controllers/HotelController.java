package com.example.MovilaApplication.Controllers;

import com.example.MovilaApplication.Models.Hotel;
import com.example.MovilaApplication.Models.Room;
import com.example.MovilaApplication.Repositories.HotelRepository;
import com.example.MovilaApplication.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/hotels")
public class HotelController {
    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    HotelService hotelService;

    @GetMapping()
    List<Hotel> getAllHotel() {
        return hotelService.getAllHotel();
    }

    @GetMapping("/getRooms/{hid}")
    List<Room> getAllRoomFromHotel(@PathVariable long hid) {
        return hotelRepository.getRoomsById(hid);
    }

    @PostMapping
    Hotel inputCode(@RequestBody Hotel hotel) {
        return hotelService.addHotel(hotel);
    }

    @PutMapping(path="{id}")
    public Optional<Hotel> updateRoom(@PathVariable("id") Long id, @RequestBody Hotel hotel){
        return hotelService.updateHotel(hotel, id);
    }

    @DeleteMapping(path="{id}")
    public Boolean deleteRoom(@PathVariable("id") Long id){
        return hotelService.deleteHotel(id);
    }
}

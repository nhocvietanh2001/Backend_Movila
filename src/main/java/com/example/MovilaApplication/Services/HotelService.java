package com.example.MovilaApplication.Services;

import com.example.MovilaApplication.Models.Hotel;
import com.example.MovilaApplication.Models.Room;
import com.example.MovilaApplication.Repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;
    @Autowired
    public HotelService(HotelRepository hotelRepository)
    {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getAllHotel() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels;
    }

    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Transactional
    public Optional<Hotel> updateHotel(Hotel newHotel, Long id){
        boolean exists = hotelRepository.existsById(id);
        if(exists) {
            Optional<Hotel> updateHotel = hotelRepository.findById(id)
                    .map(hotel -> {
                        hotel.setName(newHotel.getName());
                        hotel.setAid(hotel.getAid());
                        hotel.setAddress(hotel.getAddress());
                        hotel.setPhone(hotel.getPhone());
                        hotel.setImageURL(hotel.getImageURL());

                        return hotelRepository.save(hotel);
                    });
            return updateHotel;
        }
        return null;
    }

    public Boolean deleteHotel(Long id) {
        boolean exists = hotelRepository.existsById(id);
        if(!exists){
            return false;
        }
        else{
            hotelRepository.deleteById(id);
            return true;
        }
    }
}

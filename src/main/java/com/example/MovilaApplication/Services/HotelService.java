package com.example.MovilaApplication.Services;

import com.example.MovilaApplication.Models.Hotel;
import com.example.MovilaApplication.Repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}

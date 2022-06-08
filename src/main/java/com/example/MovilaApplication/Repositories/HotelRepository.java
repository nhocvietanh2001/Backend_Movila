package com.example.MovilaApplication.Repositories;

import com.example.MovilaApplication.Models.Hotel;
import com.example.MovilaApplication.Models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    @Query("SELECT h.rooms From Hotel h Where h.id=?1")
    public List<Room> getRoomsById(long hid);

}

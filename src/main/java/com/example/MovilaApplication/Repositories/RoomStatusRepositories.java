package com.example.MovilaApplication.Repositories;

import com.example.MovilaApplication.Models.RoomStatus;
import com.example.MovilaApplication.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomStatusRepositories extends JpaRepository<RoomStatus, Integer> {

    @Query("SELECT rs FROM RoomStatus rs WHERE rs.rid = ?1")
    RoomStatus findRoomStatusByRid(Long rid);
}

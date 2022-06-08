package com.example.MovilaApplication.Services;

import com.example.MovilaApplication.Models.RoomStatus;
import com.example.MovilaApplication.Repositories.RoomStatusRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomStatusService {


    RoomStatusRepositories roomStatusRepositories;

    @Autowired
    public RoomStatusService(RoomStatusRepositories roomStatusRepositories) {
        this.roomStatusRepositories = roomStatusRepositories;
    }

    public RoomStatus GetRoomStatus(Integer bid) {
        return roomStatusRepositories.findById(bid).get();
    }

    public RoomStatus MakeStatus(RoomStatus roomStatus) {
        return roomStatusRepositories.save(roomStatus);
    }

    public RoomStatus UpdateStatus(RoomStatus roomStatus, Long rid) {
        RoomStatus updatingRoomStatus = roomStatusRepositories.findRoomStatusByRid(rid);
        roomStatus.setId(updatingRoomStatus.getId());
        return roomStatusRepositories.save(roomStatus);
    }
}

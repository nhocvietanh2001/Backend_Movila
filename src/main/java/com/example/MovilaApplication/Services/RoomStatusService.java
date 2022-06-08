package com.example.MovilaApplication.Services;

import com.example.MovilaApplication.Models.RoomStatus;
import com.example.MovilaApplication.Repositories.RoomStatusRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoomStatusService {


    RoomStatusRepositories roomStatusRepositories;

    @Autowired
    public RoomStatusService(RoomStatusRepositories roomStatusRepositories) {
        this.roomStatusRepositories = roomStatusRepositories;
    }

    public Set<RoomStatus> GetRoomStatus(Integer bid) {
        Set<RoomStatus> roomStatusSet = new HashSet<>();
        roomStatusSet.add(roomStatusRepositories.findById(bid).get());
        return roomStatusSet;
    }

    public Set<RoomStatus> MakeStatus(RoomStatus roomStatus) {
        Set<RoomStatus> roomStatusSet = new HashSet<>();
        roomStatusSet.add(roomStatus);
        roomStatusRepositories.save(roomStatus);
        return roomStatusSet;
    }

    public Set<RoomStatus> UpdateStatus(RoomStatus roomStatus, Long rid) {
        Set<RoomStatus> roomStatusSet = new HashSet<>();
        RoomStatus updatingRoomStatus = roomStatusRepositories.findRoomStatusByRid(rid);
        roomStatus.setId(updatingRoomStatus.getId());
        roomStatusRepositories.save(roomStatus);
        roomStatusSet.add(roomStatus);
        return roomStatusSet;
    }
}

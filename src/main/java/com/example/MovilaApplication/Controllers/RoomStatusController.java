package com.example.MovilaApplication.Controllers;

import com.example.MovilaApplication.Models.RoomStatus;
import com.example.MovilaApplication.Services.BillService;
import com.example.MovilaApplication.Services.RoomStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/room_status")
public class RoomStatusController {
    @Autowired
    RoomStatusService roomStatusService;

    @GetMapping(path = "/GetRoomStatus/{bid}")
    RoomStatus GetRoomStatus(@PathVariable Integer bid){
        return roomStatusService.GetRoomStatus(bid);
    }
    @PostMapping(path = "/MakeStatus")
    RoomStatus MakeStatus(@RequestBody RoomStatus roomStatus){
        return roomStatusService.MakeStatus(roomStatus);
    }
    @PutMapping(path = "/UpdateStatus/{rid}")
    RoomStatus UpdateStatus(@RequestBody RoomStatus roomStatus, Long rid) {
        return roomStatusService.UpdateStatus(roomStatus, rid);
    }
}

package com.example.MovilaApplication.Controllers;

import com.example.MovilaApplication.Models.Bill;
import com.example.MovilaApplication.Models.Hotel;
import com.example.MovilaApplication.Models.Room;
import com.example.MovilaApplication.Models.User;
import com.example.MovilaApplication.Services.AccountService;
import com.example.MovilaApplication.Services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/bills")
public class BillController {

    @Autowired
    BillService billService;

    @GetMapping(path = "/GetBill/{bid}")
    Bill GetBillByBillID(@PathVariable Integer bid){
        return billService.GetBillByBillID(bid);
    }

//    @GetMapping(path = "/GetUserBills/{uid}")
//    List<Bill> GetUserBills(@PathVariable Long uid){
//        return billService.GetUserBills(uid);
//    }

    @PostMapping("/InsertBill")
    Boolean InsertBill(@RequestBody Bill bill){
        return billService.InsertBill(bill);
    }

    @DeleteMapping("/DeleteBill/{bid}")
    Boolean DeleteBill(@PathVariable Integer bid){
        return billService.DeleteBill(bid);
    }

    @PutMapping("/{bid}/users/{uid}")
    public Bill UpdateBill(@PathVariable Integer bid, @PathVariable Long uid) {
        return billService.UpdateBill(bid, uid);
    }
}

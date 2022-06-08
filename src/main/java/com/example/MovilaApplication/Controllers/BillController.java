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
import java.util.Set;

@RestController
@RequestMapping(path = "/bills")
public class BillController {

    @Autowired
    BillService billService;

    @GetMapping(path = "/GetBill/{bid}")
    Set<Bill> GetBillByBillID(@PathVariable Integer bid){
        return billService.GetBillByBillID(bid);
    }

//    @GetMapping(path = "/GetUserBills/{uid}")
//    List<Bill> GetUserBills(@PathVariable Long uid){
//        return billService.GetUserBills(uid);
//    }

    @PostMapping("/InsertBill/users/{uid}")
    Set<Bill> InsertBill(@RequestBody Bill bill, @PathVariable Long uid){
        return billService.InsertBill(bill, uid);
    }

    @DeleteMapping("/DeleteBill/{bid}")
    Boolean DeleteBill(@PathVariable Integer bid){
        return billService.DeleteBill(bid);
    }


}

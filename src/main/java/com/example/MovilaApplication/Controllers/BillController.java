package com.example.MovilaApplication.Controllers;

import com.example.MovilaApplication.Models.Bill;
import com.example.MovilaApplication.Models.Hotel;
import com.example.MovilaApplication.Models.Room;
import com.example.MovilaApplication.Models.User;
import com.example.MovilaApplication.Repositories.BillRepository;
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

    @Autowired
    BillRepository billRepository;

    @GetMapping(path = "users/{uid}")
    List<Bill> GetBillByUid(@PathVariable Long uid){
        return billService.GetBillByUid(uid);
    }

    @GetMapping(path = "/{bid}")
    Set<Bill> GetBillByBillID(@PathVariable Long bid){
        return billService.GetBillByBillID(bid);
    }

    @GetMapping
    List<Bill> GetAllBill() {
        return billRepository.findAll();
    }

    @PostMapping("/users/{uid}")
    Set<Bill> InsertBill(@RequestBody Bill bill, @PathVariable Long uid){
        return billService.InsertBill(bill, uid);
    }

    @DeleteMapping("/{bid}")
    Boolean DeleteBill(@PathVariable Long bid){
        return billService.DeleteBill(bid);
    }

}

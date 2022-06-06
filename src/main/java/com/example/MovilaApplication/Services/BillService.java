package com.example.MovilaApplication.Services;

import com.example.MovilaApplication.Models.Bill;
import com.example.MovilaApplication.Models.User;
import com.example.MovilaApplication.Repositories.BillRepository;
import com.example.MovilaApplication.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
    @Autowired
    BillRepository billRepository;

    @Autowired
    UserRepository userRepository;
    // Get a bill by its ID
    public Bill GetBillByBillID(Integer bid){
        Bill bill = billRepository.getById(bid);
        return bill;
    }

//    // Get a list of bills of a user
//    public List<Bill> GetUserBills(Long uid){
//        User user = userRepository.findById(uid).get();
//        List<Bill> billList = billRepository.findBillsByUid(uid);
//        for(Bill bill: billList){
//            bill.setUser_billing(user);
//        }
//        return billList;
//    }

    // Insert a bill entity
    public Boolean InsertBill(Bill bill){
        if(billRepository.existsById(bill.getId())){
            return false;
        }
        billRepository.save(bill);
        return true;
    }

    // Delete a bill by its bill id
    public Boolean DeleteBill(Integer bid) {
        try{
            billRepository.deleteById(bid);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public Bill UpdateBill(Integer bid, Long uid) {
        User user = userRepository.findById(uid).get();
        Bill bill = billRepository.findById(bid).get();
        bill.setUser_billing(user);
        return billRepository.save(bill);
    }
}

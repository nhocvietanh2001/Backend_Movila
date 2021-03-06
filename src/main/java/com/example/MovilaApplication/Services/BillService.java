package com.example.MovilaApplication.Services;

import com.example.MovilaApplication.Models.Bill;
import com.example.MovilaApplication.Models.User;
import com.example.MovilaApplication.Repositories.BillRepository;
import com.example.MovilaApplication.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BillService {
    @Autowired
    BillRepository billRepository;

    @Autowired
    UserRepository userRepository;
    // Get a bill by its ID
    public Set<Bill> GetBillByBillID(Long bid){
        try{
            Set<Bill> billSet = new HashSet<>();
            Bill bill = billRepository.findById(bid).get();
            billSet.add(bill);
            return billSet;
        }
        catch(Exception e){
            return null;
        }
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
    public Set<Bill> InsertBill(Bill bill, Long uid){
        try {
            Set<Bill> billSet = new HashSet<>();
            User user = userRepository.findById(uid).get();
            bill.setUser_billing(user);
            billRepository.save(bill);
            billSet.add(bill);
            return billSet;
        }
        catch (Exception e){
            return null;
        }
    }

    // Delete a bill by its bill id
    public Boolean DeleteBill(Long bid) {
        try{
            billRepository.deleteById(bid);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public List<Bill> GetBillByUid(Long uid) {
        User user = userRepository.findById(uid).get();
        List<Bill> billList = billRepository.findBillByUid(uid);
        return billList;
    }
}

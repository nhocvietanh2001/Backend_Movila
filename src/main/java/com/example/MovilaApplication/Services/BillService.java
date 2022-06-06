package com.example.MovilaApplication.Services;

import com.example.MovilaApplication.Models.Bill;
import com.example.MovilaApplication.Repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
    private final BillRepository billRepository;

    @Autowired
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    // Get a bill by its ID
    public Bill GetBillByBillID(Integer bid){
        Bill bill = billRepository.getById(bid);
        return bill;
    }

    // Get a list of bills of a user
    public List<Bill> GetUserBills(Integer uid){
        List<Bill> bill = billRepository.findBillsByUid(uid);
        return bill;
    }

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
}

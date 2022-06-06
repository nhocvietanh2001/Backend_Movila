package com.example.MovilaApplication.Repositories;

import com.example.MovilaApplication.Models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

//    @Query("SELECT b From Bill b Where b.uid = ?1")
//    List<Bill> findBillsByUid(Long uid);
}

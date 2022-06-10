package com.example.MovilaApplication.Controllers;

import com.example.MovilaApplication.Models.*;
import com.example.MovilaApplication.Services.AccountService;
import com.example.MovilaApplication.Services.BillService;
import com.example.MovilaApplication.Services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/contacts")
public class ContactController {

    @Autowired
    ContactService contactService;

//    @GetMapping(path = "/GetUserContact/{uid}")
//    List<Contact> GetContactByBillUser(@PathVariable Long bid){
//        return contactService.GetUserContacts(bid);
//    }

    @GetMapping
    List<Contact> getAllContact() {
        return contactService.getAllContact();
    }



    @PostMapping
    Contact InsertContact(@RequestBody Contact contact){
        return contactService.InsertContact(contact);
    }

    @DeleteMapping("/{bid}")
    Boolean DeleteContact(@PathVariable Long bid){
        return contactService.DeleteContact(bid);
    }

}

package com.example.MovilaApplication.Services;

import com.example.MovilaApplication.Models.Bill;
import com.example.MovilaApplication.Models.Contact;
import com.example.MovilaApplication.Models.Hotel;
import com.example.MovilaApplication.Models.User;
import com.example.MovilaApplication.Repositories.ContactRepository;
import com.example.MovilaApplication.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    @Autowired
    UserRepository userRepository;
    // Get a bill by its ID
//    public Set<Bill> GetBillByBillID(Long bid){
//        try{
//            Set<Bill> billSet = new HashSet<>();
//            Bill bill = billRepository.findById(bid).get();
//            billSet.add(bill);
//            return billSet;
//        }
//        catch(Exception e){
//            return null;
//        }
//    }

    // Get a list of contacts of a user
//    public List<Contact> GetUserContacts(Long uid){
//        User user = userRepository.findById(uid).get();
//        List<Contact> contactList = contactRepository.findContactByUser(uid);
//        for(Contact contact: contactList){
//            contact.setUser_contact(user);
//        }
//        return contactList;
//    }

    // Insert a contact entity
    public Contact InsertContact(Contact contact){
//        try {
//            Set<Contact> contactSet = new HashSet<>();
//            User user = userRepository.findById(uid).get();
//            contact.setUser_contact(user);
//            contactRepository.save(contact);
//            contactSet.add(contact);
//            return contactSet;
//        }
//        catch (Exception e){
//            return null;
//        }
        return contactRepository.save(contact);
    }
    // Delete a contact by its bill id
    public Boolean DeleteContact(Long bid) {
        try{
            contactRepository.deleteById(bid);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public List<Contact> getAllContact() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts;
    }

}

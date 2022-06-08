package com.example.MovilaApplication.Database;

import com.example.MovilaApplication.Models.Bill;
import com.example.MovilaApplication.Models.Hotel;
import com.example.MovilaApplication.Models.Room;
import com.example.MovilaApplication.Models.User;
import com.example.MovilaApplication.Repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase (UserRepository userRepository, HotelRepository hotelRepository, RoomRepository roomRepository, BillRepository billRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {


                User userA = new User("Viet", "Anh", "123456789", "vietanh@gmail.com", 1);
                User userB= new User("Pham Viet", "Anh", "0123213789", "vietanh123@gmail.com", 2);
                logger.info("insert data:" + userRepository.save(userA));
                logger.info("insert data:" + userRepository.save(userB));

                Bill bill1 = new Bill(19000);
                bill1.setUser_billing(userA);
                logger.info("insert data:" + billRepository.save(bill1));

                Bill bill2 = new Bill(29000);
                bill2.setUser_billing(userA);
                logger.info("insert data:" + billRepository.save(bill2));

                Bill bill3 = new Bill(39000);
                logger.info("insert data:" + billRepository.save(bill3));

//                userA.getBillList().add(bill1);
//                userA.getBillList().add(bill2);

//                logger.info("insert data:" + userRepository.save(userA));
//                logger.info("insert data:" + userRepository.save(userB));


                Room roomA = new Room("101", 1, 19000, 2, 1, 300, Boolean.TRUE, "seaview", "not so much");
                logger.info("insert data:" + roomRepository.save(roomA));
                Room roomB = new Room("102", 1, 19000, 2, 1, 300, Boolean.TRUE, "seaview", "not so much");
                Room roomC = new Room("103", 1, 19000, 2, 1, 300, Boolean.TRUE, "seaview", "not so much");
                logger.info("insert data:" + roomRepository.save(roomB));
                logger.info("insert data:" + roomRepository.save(roomC));
                List<Room> rooms = new ArrayList<>();
                //rooms.add(roomA);
                //rooms.add(roomB);
                //rooms.add(roomC);

                Hotel hotelA = new Hotel("First hotel", 1, "Di An Binh Duong", "052335184");
                //hotelA.setRooms(rooms);
                logger.info("insert data:" + hotelRepository.save(hotelA));

            }
        };
    }
}

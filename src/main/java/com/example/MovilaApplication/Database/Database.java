package com.example.MovilaApplication.Database;

import com.example.MovilaApplication.Models.Account;
import com.example.MovilaApplication.Models.Hotel;
import com.example.MovilaApplication.Models.Room;
import com.example.MovilaApplication.Models.User;
import com.example.MovilaApplication.Repositories.HotelRepository;
import com.example.MovilaApplication.Repositories.RoomRepository;
import com.example.MovilaApplication.Repositories.AccountRepository;
import com.example.MovilaApplication.Repositories.UserRepository;
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
    CommandLineRunner initDatabase (UserRepository userRepository, HotelRepository hotelRepository, RoomRepository roomRepository, AccountRepository accountRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                User userA = new User("Viet", "Anh", "123456789", "vietanh@gmail.com", 1);
                logger.info("insert data:" + userRepository.save(userA));

                Room roomA = new Room("101", 1, 19000, 2, 1, 300, Boolean.TRUE, "seaview", "not so much");
                logger.info("insert data:" + roomRepository.save(roomA));
                Room roomB = new Room("102", 1, 19000, 2, 1, 300, Boolean.TRUE, "seaview", "not so much");
                Room roomC = new Room("103", 1, 19000, 2, 1, 300, Boolean.TRUE, "seaview", "not so much");
                logger.info("insert data:" + roomRepository.save(roomB));
                logger.info("insert data:" + roomRepository.save(roomC));
                List<Room> rooms = new ArrayList<>();

                Account accountA = new Account("vietanh", "123321", "user");
                logger.info("insert data:" + accountRepository.save(accountA));

                Hotel hotelA = new Hotel("First hotel", 1, "Di An Binh Duong", "052335184");
                //hotelA.setRooms(rooms);
                logger.info("insert data:" + hotelRepository.save(hotelA));
            }
        };
    }
}

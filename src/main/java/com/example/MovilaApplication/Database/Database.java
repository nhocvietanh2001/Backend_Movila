package com.example.MovilaApplication.Database;

import com.example.MovilaApplication.Models.*;
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
    CommandLineRunner initDatabase (UserRepository userRepository, HotelRepository hotelRepository, RoomRepository roomRepository, AccountRepository accountRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                User userA = new User("Viet", "Anh", "123456789", "vietanh@gmail.com");
                Account accountA = new Account("vietanh", "123321", "user");
                accountA.setUser(userA);
                userA.setAccount(accountA);
                logger.info("insert data:" + userRepository.save(userA));
                logger.info("insert data:" + accountRepository.save(accountA));

                Room roomA = new Room("101","luxury", 19000, 2, 1, 300, Boolean.TRUE, "seaview", "much much not to","https://firebasestorage.googleapis.com/v0/b/algebraic-fin-332903.appspot.com/o/1.jpg?alt=media&token=768ec2b9-503f-4232-8355-1977aa081509");
                Room roomB = new Room("102","luxury", 19000, 2, 1, 300, Boolean.TRUE, "seaview", "not so much","https://firebasestorage.googleapis.com/v0/b/algebraic-fin-332903.appspot.com/o/1.jpg?alt=media&token=768ec2b9-503f-4232-8355-1977aa081509");
                Room roomC = new Room("103","normal", 19000, 2, 1, 300, Boolean.TRUE, "seaview", "not so much","https://firebasestorage.googleapis.com/v0/b/algebraic-fin-332903.appspot.com/o/1.jpg?alt=media&token=768ec2b9-503f-4232-8355-1977aa081509");
                logger.info("insert data:" + roomRepository.save(roomA));
                logger.info("insert data:" + roomRepository.save(roomB));
                logger.info("insert data:" + roomRepository.save(roomC));
                List<Room> rooms = new ArrayList<>();



                Hotel hotelA = new Hotel("First hotel", 1, "Di An Binh Duong", "052335184", "https://firebasestorage.googleapis.com/v0/b/algebraic-fin-332903.appspot.com/o/5.jpg?alt=media&token=dd1b7124-5ad6-4860-8978-2a6e7c147cb6");
                //hotelA.setRooms(rooms);
                logger.info("insert data:" + hotelRepository.save(hotelA));


            }
        };
    }
}

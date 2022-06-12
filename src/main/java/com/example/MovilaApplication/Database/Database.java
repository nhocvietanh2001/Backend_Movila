package com.example.MovilaApplication.Database;

import com.example.MovilaApplication.Models.*;
import com.example.MovilaApplication.Repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase (UserRepository userRepository, HotelRepository hotelRepository, RoomRepository roomRepository, AccountRepository accountRepository, BillRepository billRepository, BookingRepository bookingRepository, ContactRepository contactRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                User userA = new User("Viet", "Anh", "123456789", "vietanh@gmail.com");
                User userB = new User("Khoa", "Tran", "123456789","khoatran@gmail.com");
                Account accountA = new Account("vietanh", "123321", "user");
                Account accountB = new Account("khoatran", "123456", "user");
                accountA.setUser(userA);
                userA.setAccount(accountA);
                logger.info("insert data:" + userRepository.save(userA));

                accountB.setUser(userB);
                userB.setAccount(accountB);
                logger.info("insert data:" + userRepository.save(userB));

                Room room1 = new Room("101","single", 100, 1, 1, 40, Boolean.TRUE, "Seaview", "Fully equipped, suitable for 1 person, quiet, cool, high security","https://firebasestorage.googleapis.com/v0/b/algebraic-fin-332903.appspot.com/o/ba1.jpg?alt=media&token=63347c92-8b47-4fec-b538-fcb8af4a15a1");
                Room room2 = new Room("102","single", 120, 1, 1, 45, Boolean.TRUE, "Seaview", "Nice view, suitable for 1 person, pleasant atmosphere, quiet, good security","https://firebasestorage.googleapis.com/v0/b/algebraic-fin-332903.appspot.com/o/ba1.jpg?alt=media&token=63347c92-8b47-4fec-b538-fcb8af4a15a1");
                Room room3 = new Room("103","double", 140, 2, 1, 60, Boolean.TRUE, "Streetview", "Large space, fully equipped, chill view and high security, suitable for 2 people","https://firebasestorage.googleapis.com/v0/b/algebraic-fin-332903.appspot.com/o/doi1.jpg?alt=media&token=979fe214-05a8-4978-b687-cec7a12d0c2d");
                Room room4 = new Room("104","double", 150, 2, 1, 60, Boolean.TRUE, "Seaview", "Large space, fully equipped, chill view and high security, suitable for 2 people","https://firebasestorage.googleapis.com/v0/b/algebraic-fin-332903.appspot.com/o/doi1.jpg?alt=media&token=979fe214-05a8-4978-b687-cec7a12d0c2d");
                Room room5 = new Room("105","special", 200, 4, 1, 80, Boolean.TRUE, "Seaview", "Vip view, suitable for 4 people, pleasant atmosphere, quiet, good security, private space","https://firebasestorage.googleapis.com/v0/b/algebraic-fin-332903.appspot.com/o/don1.jpg?alt=media&token=bc240298-558d-4ae1-8fee-0174354e5d30");

                logger.info("insert data:" + roomRepository.save(room1));
                logger.info("insert data:" + roomRepository.save(room2));
                logger.info("insert data:" + roomRepository.save(room3));
                logger.info("insert data:" + roomRepository.save(room4));
                logger.info("insert data:" + roomRepository.save(room5));

                Room room6 = new Room("101","single", 80, 1, 1, 30, Boolean.TRUE, "Streetview", "Fully equipped, suitable for 1 person, quiet, cool, high security","https://firebasestorage.googleapis.com/v0/b/algebraic-fin-332903.appspot.com/o/don2.jpg?alt=media&token=01b6a61b-a5ab-43a1-b597-117f1c910109");
                Room room7 = new Room("102","single", 100, 1, 1, 35, Boolean.TRUE, "Streetview", "Nice view, suitable for 1 person, pleasant atmosphere, quiet, good security","https://firebasestorage.googleapis.com/v0/b/algebraic-fin-332903.appspot.com/o/don2.jpg?alt=media&token=01b6a61b-a5ab-43a1-b597-117f1c910109");
                Room room8 = new Room("103","double", 150, 2, 1, 60, Boolean.TRUE, "Streetview", "Large space, fully equipped, chill view and high security, suitable for 2 people","https://firebasestorage.googleapis.com/v0/b/algebraic-fin-332903.appspot.com/o/doi2.jpg?alt=media&token=47bbb9be-087e-493c-aee0-3dcc657feaca");
                Room room9 = new Room("201","double", 170, 2, 2, 60, Boolean.TRUE, "Cityview", "Large space, fully equipped, chill view and high security, suitable for 2 people","https://firebasestorage.googleapis.com/v0/b/algebraic-fin-332903.appspot.com/o/doi2.jpg?alt=media&token=47bbb9be-087e-493c-aee0-3dcc657feaca");
                Room room10 = new Room("202","special", 200, 4, 2, 80, Boolean.TRUE, "Cityview", "Vip view, suitable for 4 people, pleasant atmosphere, quiet, good security, private space","https://firebasestorage.googleapis.com/v0/b/algebraic-fin-332903.appspot.com/o/ba3.jpg?alt=media&token=877ca017-7a1a-4f55-b5d7-9e85b4ca09d3");

                logger.info("insert data:" + roomRepository.save(room6));
                logger.info("insert data:" + roomRepository.save(room7));
                logger.info("insert data:" + roomRepository.save(room8));
                logger.info("insert data:" + roomRepository.save(room9));
                logger.info("insert data:" + roomRepository.save(room10));

                Hotel hotelA = new Hotel("Sao Mai hotel", "saomaihotel@gmail.com", "29 Le Duan, district 1", "052335184", "https://firebasestorage.googleapis.com/v0/b/algebraic-fin-332903.appspot.com/o/1.jpg?alt=media&token=768ec2b9-503f-4232-8355-1977aa081509");
                Account accountHotelA = new Account("saomai", "123", "hotel");

                accountHotelA.setHotelaccount(hotelA);
                hotelA.setAccount(accountHotelA);

                logger.info("insert data:" + accountRepository.save(accountHotelA));

                Hotel hotelB = new Hotel("Hoang Gia Hotel", "hoanggiahotel@gmail.com", "29 Le Duan, district 1", "013331898", "https://firebasestorage.googleapis.com/v0/b/algebraic-fin-332903.appspot.com/o/2.jpg?alt=media&token=ec91db7f-c7e4-4f45-bf21-41cd02060051");
                Account accountHotelB = new Account("hoanggia", "123", "hotel");

                accountHotelB.setHotelaccount(hotelB);
                hotelB.setAccount(accountHotelB);

                logger.info("insert data:" + accountRepository.save(accountHotelB));
                Contact contact = new Contact("Dat", "Nguyen", "0378911238", "dat@gmail", "Noi dung", "Chi tiet noi dung");
                 contactRepository.save(contact);
            }
        };
    }
}

package com.example.Course_Booking_System.Components;

import com.example.Course_Booking_System.Models.Booking;
import com.example.Course_Booking_System.Models.Course;
import com.example.Course_Booking_System.Models.Customer;
import com.example.Course_Booking_System.Models.StarRating;
import com.example.Course_Booking_System.Repositories.BookingRepository;
import com.example.Course_Booking_System.Repositories.CourseRepository;
import com.example.Course_Booking_System.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader() {
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

        Customer frasier = new Customer("Frasier", "Boston", 40);
        customerRepository.save(frasier);

        Customer niles = new Customer("Niles", "Seattle", 37);
        customerRepository.save(niles);

        Customer martin = new Customer("Martin", "Seattle", 65);
        customerRepository.save(martin);

        Customer daphne = new Customer("Daphne", "Manchester", 30);
        customerRepository.save(daphne);

        Customer eddie = new Customer("Eddie", "Dohg Heaven", 16);
        customerRepository.save(eddie);

        Customer roz = new Customer("Roz", "Bloomer", 32);
        customerRepository.save(roz);

        Course mcTraining = new Course("Be a better MC", "Seattle", StarRating.FOUR_STAR);
        courseRepository.save(mcTraining);

        Course dogAgility = new Course("Man's better best friend", "Leith", StarRating.THREE_STAR );
        courseRepository.save(dogAgility);

        Course wineTasting = new Course("Wine tasting", "Seattle", StarRating.FIVE_STAR);
        courseRepository.save(wineTasting);

        Course taxidermy = new Course("slice-a-corpse", "Boston", StarRating.ONE_STAR);
        courseRepository.save(taxidermy);

        Booking booking1 = new Booking("01-07-22", frasier, wineTasting );
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("01-07-22", niles, wineTasting );
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("04-07-22", martin, dogAgility );
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("04-07-22", eddie, dogAgility );
        bookingRepository.save(booking4);

        Booking booking5 = new Booking("06-07-22", roz, taxidermy );
        bookingRepository.save(booking5);

        Booking booking6 = new Booking("010-07-22", frasier, mcTraining );
        bookingRepository.save(booking6);

        frasier.addBooking(booking1);
        frasier.addBooking(booking6);
        customerRepository.save(frasier);

        niles.addBooking(booking2);
        customerRepository.save(niles);

        martin.addBooking(booking3);
        customerRepository.save(martin);

        eddie.addBooking(booking4);
        customerRepository.save(eddie);

        roz.addBooking(booking5);
        customerRepository.save(roz);

        wineTasting.addBooking(booking1);
        wineTasting.addBooking(booking2);
        courseRepository.save(wineTasting);

        dogAgility.addBooking(booking3);
        dogAgility.addBooking(booking4);
        courseRepository.save(dogAgility);

        taxidermy.addBooking(booking5);
        courseRepository.save(taxidermy);

        mcTraining.addBooking(booking6);
        courseRepository.save(mcTraining);









    }
}

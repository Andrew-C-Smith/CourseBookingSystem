package com.example.Course_Booking_System.Controllers;

import com.example.Course_Booking_System.Models.Booking;
import com.example.Course_Booking_System.Models.Customer;
import com.example.Course_Booking_System.Repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")

    public ResponseEntity<List<Booking>> getAllBookings(
            @RequestParam(name = "date", required = false)String date){
        if(date != null){
            return new ResponseEntity(bookingRepository.findByDate(date), HttpStatus.OK);
        }
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);

    }

    @GetMapping(value = "/bookings/{id}")
    public Optional<Booking> getBooking(@PathVariable Long id){
        return bookingRepository.findById(id);
    }

    @PostMapping(value = "/bookings")
    public ResponseEntity<Booking> postBookings(@RequestBody Booking booking) {
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }
}

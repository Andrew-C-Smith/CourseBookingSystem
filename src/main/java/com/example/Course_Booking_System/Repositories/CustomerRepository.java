package com.example.Course_Booking_System.Repositories;


import com.example.Course_Booking_System.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select c from Customer c inner join c.bookings bookings where bookings.course.name = ?1")
    List<Customer> findByBookings_Course_Name(String name);

    @Query("select c from Customer c inner join c.bookings bookings where c.town = ?1 and bookings.course.name = ?2")
    List<Customer> findByTownAndBookings_Course_Name(String town, String name);



}

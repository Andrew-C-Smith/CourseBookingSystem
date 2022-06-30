package com.example.Course_Booking_System.Repositories;

import com.example.Course_Booking_System.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("select b from Booking b where b.date = ?1")
    List<Booking> findByDate(String date);
}

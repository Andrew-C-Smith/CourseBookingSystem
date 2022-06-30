package com.example.Course_Booking_System.Repositories;

import com.example.Course_Booking_System.Models.Course;
import com.example.Course_Booking_System.Models.StarRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("select c from Course c inner join c.bookings bookings where bookings.course.starRating = ?1")
    List<Course> findByBookings_Course_StarRating(StarRating starRating);

    @Query("select c from Course c inner join c.bookings bookings where bookings.customer.name = ?1")
    List<Course> findByBookings_Customer_Name(String name);


}

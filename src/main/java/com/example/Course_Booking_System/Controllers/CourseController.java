package com.example.Course_Booking_System.Controllers;

import com.example.Course_Booking_System.Models.Course;
import com.example.Course_Booking_System.Models.Customer;
import com.example.Course_Booking_System.Models.StarRating;
import com.example.Course_Booking_System.Repositories.CourseRepository;
import com.sun.jdi.NativeMethodException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses(
            @RequestParam(name= "starRating", required = false)StarRating starRating,
            @RequestParam(name= "customerName", required = false)String customerName)
    {
    if(starRating != null){
        return new ResponseEntity(courseRepository.findByBookings_Course_StarRating(starRating), HttpStatus.OK);
    }
    if(customerName != null){
        return new ResponseEntity(courseRepository.findByBookings_Customer_Name(customerName), HttpStatus.OK);
    }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/{id}")
    public Optional<Course> getCourse(@PathVariable Long id){
        return courseRepository.findById(id);
    }


    @PostMapping(value = "/courses")
    public ResponseEntity<Course> postCourses(@RequestBody Course  course) {
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }
}

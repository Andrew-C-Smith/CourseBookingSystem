package com.example.Course_Booking_System.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Column(name= "name")
    private String name;
    @Column(name = "town")
    private String town;
    @Column(name = "star_rating")
    private StarRating starRating;

    @OneToMany(mappedBy = "course", fetch= FetchType.LAZY)
    @JsonIgnoreProperties({"course"})
    private List<Booking> bookings;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;


    }

    public Course() {
    }

    public Course(String name, String town, StarRating starRating) {
        this.name = name;
        this.town = town;
        this.starRating = starRating;
        this.bookings = new ArrayList<>();
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public StarRating getStarRating() {
        return starRating;
    }

    public void setStarRating(StarRating starRating) {
        this.starRating = starRating;
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }
}

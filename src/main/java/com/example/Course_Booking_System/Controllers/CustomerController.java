package com.example.Course_Booking_System.Controllers;

import com.example.Course_Booking_System.Models.Customer;
import com.example.Course_Booking_System.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.ServerEndpoint;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(name = "course", required = false) String course,
            @RequestParam(name= "town", required = false)String town,
            @RequestParam(name = "courseName", required = false)String courseName) {
        if(course != null){
            return new ResponseEntity(customerRepository.findByBookings_Course_Name(course), HttpStatus.OK);
        }
        if(town != null && courseName != null){
            return new ResponseEntity(customerRepository.findByTownAndBookings_Course_Name(town,courseName), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);

    }



    @GetMapping(value = "/customers/{id}")
    public Optional<Customer> getCustomer(@PathVariable Long id){
        return customerRepository.findById(id);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

}

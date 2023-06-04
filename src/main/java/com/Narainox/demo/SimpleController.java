package com.Narainox.demo;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SimpleController {

    @Autowired
    DbUser dbUser;

    @GetMapping("/hi")
    public String sayHi() {
        return "Hello Ayush From Our Server!";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return dbUser.getAllUser();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        return dbUser.getUser(id);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id) {
        return dbUser.deleteUser(id);
    }

    @PostMapping("/createUser")
    public String createUser(@RequestBody User user) {
        return dbUser.createUser(user);
    }

    @GetMapping("/getUserByName")
    public String getUserbyName(@RequestParam int q) {
        return dbUser.getUserByName(q);
    }
}

    /*
## Day-2 ##
============

SpringBoot is a extenstion of Spring that contains all the feactures of Spring.

-Dependancy management tool
->Maven
->Gradle

-Spring Boot Starter
Spring initilizer
->Maven
->com.Narainox Demo
->Java 17
->Dependancy
---->Spring web

Upload Project
new->Project from exiting sources.

browser->
http://localhost:8080/hi

## API ##
===========
SOAP x
REST

## Types of API's ##
=======================
->GET-  Fetching the data from server.
->POST-  Uploading or creating or writing the new Data in the server.
->DELETE- Deleting the data from the server.
->PUT- Updating the existing data in the server.

Parameters
users/ayush --> Path Parameter
search?q=Ayush ---> query Parameter----->RequestPARAM





*/


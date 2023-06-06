package com.Narainox.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@RestController
public class SimpleController {

        @Autowired
        DbUser dbUser;

        @RequestMapping(path = "/hii", method = RequestMethod.GET,consumes = "application/json",produces = "application/json")
//        @GetMapping("/hi")
        public String sayHi() {
            return "Hello Ayush From Our Server!";
        }

        @GetMapping("/users")
        public List<User> getAllUsers() {
            return dbUser.getAllUser();
        }

        @GetMapping("/users/{id}")
        public ResponseEntity<User> getUser(@PathVariable int id) {
            User user= dbUser.getUser(id);
            MultiValueMap<String,String> headers=new LinkedMultiValueMap<>();
            headers.put("server", Collections.singletonList("CodeOfAyush"));
            HttpStatus status=HttpStatus.CREATED;
            ResponseEntity<User> responseEntity=new ResponseEntity<User>(user,headers,status);
            return responseEntity;
        }

        @DeleteMapping("/user/{id}")
        public String deleteUser(@PathVariable int id) {
            return dbUser.deleteUser(id);
        }

        @PostMapping("/createUser")
        // @ResponseStatus(HttpStatus.CREATED) by default its return 200.
        public String createUser(@RequestBody User user) {
            return dbUser.createUser(user);
        }

        @GetMapping("/getUserByName")
        public String getUserbyName(@RequestParam int q) {
            return dbUser.getUserByName(q);
        }

        @PutMapping("/updateUser/{id}")
        public User updateUser(@RequestBody User user,@PathVariable int id)
        {
            return dbUser.updateUserById(user,id);
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

HTTP Status Code
4XX- ISSUE with client Bad API
2XX- Fine
5XX- issue with server
3XX- ITS fine but server not responds with client.




*/


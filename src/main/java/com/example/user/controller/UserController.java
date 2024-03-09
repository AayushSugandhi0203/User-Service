package com.example.user.controller;

import com.example.user.Entity.User;
import com.example.user.Response.ApiResponse;
import com.example.user.ServiceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;
    @RequestMapping(value = "/users",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers(){
        try {
            List<User> users = userService.getAllUsers();
            System.out.println(users.toString());

            ApiResponse<List<User>> apiResponse = new ApiResponse<>("Data Fetched Successfully", HttpStatus.OK.value(), true, users);
            return ResponseEntity.status(200).body(apiResponse);
        } catch (Exception e) {
            ApiResponse<List<User>> apiResponse = new ApiResponse<>(e.getMessage(), 500, true, null);
            return ResponseEntity.status(500).body(apiResponse);
        }
    }

    @RequestMapping (value ="/users",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<User>> createNewUser(@RequestBody User user) {
        try {
            System.out.println(user);
            User users = userService.createUser(user);
            ApiResponse<User> apiResponse = new ApiResponse<>("Data Fetched Successfully", HttpStatus.OK.value(), true, users);
            return ResponseEntity.status(200).body(apiResponse);
        } catch (Exception e) {
            ApiResponse<User> apiResponse = new ApiResponse<>(e.getMessage(), 500, true, null);
            return ResponseEntity.status(500).body(apiResponse);
        }
    }

    @RequestMapping (value ="/users/{userId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<User>> getSingleUser(@PathVariable Integer userId) {
        try {
            User users = userService.getUser(userId);
            ApiResponse<User> apiResponse = new ApiResponse<>("Data Fetched Successfully", HttpStatus.OK.value(), true, users);
            return ResponseEntity.status(200).body(apiResponse);
        } catch (Exception e) {
            ApiResponse<User> apiResponse = new ApiResponse<>(e.getMessage(), 500, true, null);
            return ResponseEntity.status(500).body(apiResponse);
        }
    }
}

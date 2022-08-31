package com.devmountain.NoteApp.controllers;

import com.devmountain.NoteApp.dtos.UserDto;
import com.devmountain.NoteApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //NEED TO FINISH!! STEP 3 DAY 3

    @PostMapping("/register")
    public List<String> addUser(@RequestBody UserDto userDto)
    {
    return null;
    }
}

package uz.university.miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.university.miniproject.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    //
    @Autowired
    private UserService userService;
}

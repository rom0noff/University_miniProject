package uz.university.miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.university.miniproject.entity.model.User;
import uz.university.miniproject.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    //
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity createInfo(@RequestBody User user){
        if(!checkPasswordLength(user.getPassword())){
            return new ResponseEntity("password must not be less than 5 characters", HttpStatus.BAD_REQUEST);
        }
        if(userService.checkUserName(user.getUserName())){
            return new ResponseEntity("this login is registered", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userService.createSave(user));
    }
    private Boolean checkPasswordLength(String password){
        return password.length() > 5;
    }
}

package uz.university.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.university.miniproject.entity.model.User;
import uz.university.miniproject.repository.UserRepo;

import java.util.Locale;

@Service
public class UserService {
    //
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createSave(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public Boolean checkUserName(String userName){
        return userRepo.existsByUserName(userName);
    }
}

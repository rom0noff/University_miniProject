package uz.university.miniproject.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.university.miniproject.entity.model.User;
import uz.university.miniproject.repository.UserRepo;

@Service
public class UserService {
    //
    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public User createSave(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public Boolean checkUserName(String userName){
        return userRepo.existsByUserName(userName);
    }
}

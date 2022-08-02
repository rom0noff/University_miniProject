package uz.university.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.university.miniproject.repository.UserRepo;

@Service
public class UserService {
    //
    @Autowired
    private UserRepo userRepo;
}

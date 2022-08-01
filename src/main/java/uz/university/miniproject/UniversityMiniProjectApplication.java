package uz.university.miniproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import uz.university.miniproject.entity.model.Course;
import uz.university.miniproject.service.CourseService;

import java.util.Date;

@SpringBootApplication
public class UniversityMiniProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniversityMiniProjectApplication.class, args);
    }

}

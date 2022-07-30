package uz.university.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.university.miniproject.entity.model.Course;
import uz.university.miniproject.repository.CourseRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    //
    @Autowired
    private CourseRepo courseRepo;

    public Course save(Course course){
        return courseRepo.save(course);
    }
    public List<Course> findAll(){
        return (List<Course>) courseRepo.findAll();
    }
    public Optional<Course> findById(Long id){
        return courseRepo.findById(id);
    }
    public void deleteById(Long id){
        courseRepo.deleteById(id);
    }
    public void deleteAll(){
        courseRepo.deleteAll();
    }
}

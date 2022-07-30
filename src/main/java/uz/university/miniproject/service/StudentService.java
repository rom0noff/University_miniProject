package uz.university.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.university.miniproject.entity.model.Student;
import uz.university.miniproject.repository.StudentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    //
    @Autowired
    private StudentRepo studentRepo;

    public Student save(Student student){
        return studentRepo.save(student);
    }
    public List<Student> findAll(){
       return (List<Student>) studentRepo.findAll();
    }
    public Optional<Student> findById(Long id){
        return studentRepo.findById(id);
    }
    public void deleteAll(){
        studentRepo.deleteAll();
    }
    public void deleteById(Long id){
        studentRepo.deleteById(id);
    }

}

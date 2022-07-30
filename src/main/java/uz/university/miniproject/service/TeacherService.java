package uz.university.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.university.miniproject.entity.model.Teacher;
import uz.university.miniproject.repository.TeacherRepo;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    //
    @Autowired
    private TeacherRepo teacherRepo;

    public Teacher save(Teacher teacher){
        return teacherRepo.save(teacher);
    }
    public List<Teacher> findAll(){
        return (List<Teacher>) teacherRepo.findAll();
    }
    public Optional<Teacher> findById(Long id){
        return teacherRepo.findById(id);
    }
    public void deleteAll(){
        teacherRepo.deleteAll();
    }
    public void deleteById(Long id){
        teacherRepo.deleteById(id);
    }
}

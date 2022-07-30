package uz.university.miniproject.repository;

import org.springframework.data.repository.CrudRepository;
import uz.university.miniproject.entity.model.Student;

public interface StudentRepo extends CrudRepository<Student, Long> {
}

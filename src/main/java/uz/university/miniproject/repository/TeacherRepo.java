package uz.university.miniproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.university.miniproject.entity.model.Teacher;

@Repository
public interface TeacherRepo extends CrudRepository<Teacher, Long> {
}

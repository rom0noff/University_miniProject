package uz.university.miniproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.university.miniproject.entity.model.Course;

@Repository
public interface CourseRepo extends CrudRepository<Course,Long> {
}

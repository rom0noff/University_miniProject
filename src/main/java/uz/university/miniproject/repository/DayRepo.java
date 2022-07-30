package uz.university.miniproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.university.miniproject.entity.model.Day;

@Repository
public interface DayRepo extends CrudRepository<Day,Long> {
}

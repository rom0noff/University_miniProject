package uz.university.miniproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.university.miniproject.entity.model.TimeTable;

@Repository
public interface TimeTableRepo extends CrudRepository<TimeTable, Long> {
}

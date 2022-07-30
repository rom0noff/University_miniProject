package uz.university.miniproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.university.miniproject.entity.model.Room;

@Repository
public interface RoomRepo extends CrudRepository<Room, Long> {
    //
}

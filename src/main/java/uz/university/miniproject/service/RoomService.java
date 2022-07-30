package uz.university.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.university.miniproject.entity.model.Room;
import uz.university.miniproject.repository.RoomRepo;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    //
    @Autowired
    private RoomRepo roomRepo;
    public Room save(Room room){
        return roomRepo.save(room);
    }
    public List<Room> findAll(){
        return (List<Room>) roomRepo.findAll();
    }
    public Optional<Room> findById(Long id){
        return roomRepo.findById(id);
    }
    public void deleteAll(){
        roomRepo.deleteAll();
    }
    public void deleteById(Long id){
        roomRepo.deleteById(id);
    }
}

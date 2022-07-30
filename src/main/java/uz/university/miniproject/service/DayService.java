package uz.university.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.university.miniproject.entity.model.Day;
import uz.university.miniproject.repository.DayRepo;

import java.util.List;
import java.util.Optional;

@Service
public class DayService {
    //
    @Autowired
    private DayRepo dayRepo;

    public Day save(Day day){
        return dayRepo.save(day);
    }
    public List<Day> findAll(){
        return (List<Day>) dayRepo.findAll();
    }
    public Optional<Day> findById(Long id){
        return dayRepo.findById(id);
    }
    public void deleteById(Long id){
        dayRepo.deleteById(id);
    }
    public void deleteAll(){
        dayRepo.deleteAll();
    }
}

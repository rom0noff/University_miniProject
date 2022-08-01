package uz.university.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.university.miniproject.entity.model.Teacher;
import uz.university.miniproject.entity.model.TimeTable;
import uz.university.miniproject.repository.TimeTableRepo;
import java.util.List;
import java.util.Optional;

@Service
public class TimeTableService {
    //
    @Autowired
    private TimeTableRepo timeTableRepo;

    public TimeTable save(TimeTable timeTable){
        return timeTableRepo.save(timeTable);
    }
    public List<TimeTable> findAll(){
        return (List<TimeTable>) timeTableRepo.findAll();
    }
    public Optional<TimeTable> findById(Long id){
        return timeTableRepo.findById(id);
    }
    public void deleteAll(){
        timeTableRepo.deleteAll();
    }
    public void deleteById(Long id){
        timeTableRepo.deleteById(id);
    }
}

package arhip.barber.controller;

import arhip.barber.entity.WorkingHours;
import arhip.barber.repository.WorkingHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class WorkingHoursController {

    @Autowired
    private WorkingHoursRepository workingHoursRepository;

    @RequestMapping(value = "/working_hours", method = RequestMethod.POST)
    public WorkingHours addWorkingHours(@RequestBody WorkingHours workingHours){
        return workingHoursRepository.save(workingHours);
    }
}

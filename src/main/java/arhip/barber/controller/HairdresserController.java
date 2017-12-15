package arhip.barber.controller;

import arhip.barber.entity.Entry;
import arhip.barber.entity.Hairdresser;
import arhip.barber.entity.WorkingHours;
import arhip.barber.repository.EntriesRepository;
import arhip.barber.repository.HairdresserRepository;
import arhip.barber.repository.WorkingHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

@RestController
public class HairdresserController {

    @Autowired
    private HairdresserRepository hairdresserRepository;

    @Autowired
    private EntriesRepository entriesRepository;

    @Autowired
    private WorkingHoursRepository workingHoursRepository;

    @RequestMapping(value = "/hairdresser", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Hairdresser> getAllHairdressers() {
        return hairdresserRepository.findAll();
    }

    @RequestMapping(value = "/hairdresser/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Hairdresser getHairdresser(@PathVariable("id") long ID) {
        return hairdresserRepository.findOne(ID);
    }

    @RequestMapping(value = "/hairdresser", params = {"lastname","password"}, method = RequestMethod.GET)
    public Hairdresser getHairdresser(@RequestParam("lastname") String lastname, @RequestParam("password") String password){
        return hairdresserRepository.findByLastNameAndPassword(lastname,password);
    }
    @RequestMapping(value = "/hairdresser", method = RequestMethod.PUT)
    @ResponseBody
    public Hairdresser saveHairdresser(@RequestBody Hairdresser hairdresser) {
        return hairdresserRepository.save(hairdresser);
    }

    @RequestMapping(value = "/hairdresser/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        hairdresserRepository.delete(id);
    }

    @RequestMapping(value = "/hairdresser/{id}/working_hours", method = RequestMethod.GET)
    @ResponseBody
    public WorkingHours getWorkingHours(@PathVariable("id") long ID){
        return workingHoursRepository.findOne(ID);
    }

    @RequestMapping(value = "/hairdresser/{id}/entries", method = RequestMethod.GET)
    @ResponseBody
    public List<Entry> getEntries(@PathVariable("id") long ID){
        return entriesRepository.findByHairdresserId(ID);
    }
}

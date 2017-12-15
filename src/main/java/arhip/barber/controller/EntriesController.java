package arhip.barber.controller;


import arhip.barber.entity.Entry;
import arhip.barber.repository.BarberUserRepository;
import arhip.barber.repository.EntriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntriesController {

    @Autowired
    private EntriesRepository entriesRepository;

    @RequestMapping(value = "/entry/{id}/barber_user/name", method = RequestMethod.GET)
    @ResponseBody
    public String getClientOfEntry(@PathVariable("id") long ID){
        return null;//entriesRepository.findOne(ID).getBarberUser().getLogin();
    }

    @RequestMapping(value = "/entry", method = RequestMethod.GET)
    public Iterable<Entry> getEntries(){
        return entriesRepository.findAll();
    }

    @RequestMapping(value = "/entry", method = RequestMethod.POST)
    public Entry addEntry(@RequestBody Entry entry){
        return entriesRepository.save(entry);
    }
}

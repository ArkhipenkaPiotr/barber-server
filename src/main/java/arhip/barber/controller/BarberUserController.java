package arhip.barber.controller;

import arhip.barber.entity.Accessable;
import arhip.barber.entity.BarberUser;
import arhip.barber.entity.Entry;
import arhip.barber.entity.Hairdresser;
import arhip.barber.repository.BarberUserRepository;
import arhip.barber.repository.EntriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BarberUserController {

    @Autowired
    BarberUserRepository barberUserRepository;

    @Autowired
    EntriesRepository entriesRepository;

    @RequestMapping(value = "/barber_user",params = {"login","password"}, method = RequestMethod.GET)
    public BarberUser getUser(@RequestParam(value = "login") String login, @RequestParam(value = "password") String password){
        return barberUserRepository.findByLoginAndPassword(login,password);
    }

    @RequestMapping(value = "/barber_user", method = RequestMethod.GET)
    public Iterable<BarberUser> getUsers(){
        return barberUserRepository.findAll();
    }

    @RequestMapping(value = "/barber_user/{id}", method = RequestMethod.GET)
    public BarberUser getUser(@PathVariable("id") long id){
        return barberUserRepository.findOne(id);
    }


    @RequestMapping(value = "/barber_user/registration", params = {"login","password"},method = RequestMethod.POST)
    public BarberUser addUser(@RequestParam(value = "login") String login, @RequestParam(value = "password") String password){
        if (barberUserRepository.findByLogin(login)==null) {
            BarberUser barberUser = new BarberUser(login, password, Accessable.TYPE_USER);
            barberUserRepository.save(barberUser);
            return barberUserRepository.findByLoginAndPassword(login, password);
        }
        else {
            return null;
        }
    }

    @RequestMapping(value = "/barber_user", method = RequestMethod.PUT)
    @ResponseBody
    public BarberUser saveBarberUser(@RequestBody BarberUser barberUser) {
        return barberUserRepository.save(barberUser);
    }

    @RequestMapping(value = "/barber_user/{id}/entries", method = RequestMethod.GET)
    public List<Entry> getEntriesOf(@PathVariable("id") long id){
        return entriesRepository.findByBarberUserId(id);
    }
}

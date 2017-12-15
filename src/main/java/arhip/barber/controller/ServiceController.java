package arhip.barber.controller;

import arhip.barber.entity.Service;
import arhip.barber.repository.ServiceRepository;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceController {

    @Autowired
    ServiceRepository serviceRepository;

    @RequestMapping(value = "/service",method = RequestMethod.GET)
    public Iterable<Service> getServices(){
        return serviceRepository.findAll();
    }

    @RequestMapping(value = "/service", method = RequestMethod.POST)
    public Service saveService(@RequestBody Service service){
        return serviceRepository.save(service);
    }

    @RequestMapping(value="/service", method = RequestMethod.DELETE)
    public void deleteService(@RequestBody Service service){
        serviceRepository.delete(service);
    }

    @RequestMapping(value = "/service/by_name", method = RequestMethod.GET)
    public void getService(@RequestParam("name") String name){
        serviceRepository.findByName(name);
    }
}

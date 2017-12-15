package arhip.barber.repository;

import arhip.barber.entity.Service;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<Service,Long> {
    public Service findByName(String name);
}

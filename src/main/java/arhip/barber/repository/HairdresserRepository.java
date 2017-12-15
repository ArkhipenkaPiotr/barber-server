package arhip.barber.repository;

import arhip.barber.entity.Hairdresser;
import org.springframework.data.repository.CrudRepository;

public interface HairdresserRepository extends CrudRepository<Hairdresser,Long> {
    Hairdresser findByLastNameAndPassword(String lastName, String password);
}

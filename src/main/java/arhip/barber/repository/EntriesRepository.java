package arhip.barber.repository;

import arhip.barber.entity.Entry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EntriesRepository extends CrudRepository<Entry,Long> {
    List<Entry> findByHairdresserId(long id);
    List<Entry> findByBarberUserId(long id);
}

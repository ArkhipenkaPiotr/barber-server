package arhip.barber.repository;

import arhip.barber.entity.Accessable;
import arhip.barber.entity.BarberUser;
import org.springframework.data.repository.CrudRepository;

public interface BarberUserRepository extends CrudRepository<BarberUser,Long> {
    BarberUser findByLoginAndPassword(String login, String password);
    BarberUser findByLogin(String login);
    Iterable<BarberUser> findById(long id);
}

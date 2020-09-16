package RestaurantReservation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationStatusRepository extends CrudRepository<ReservationStatus, Long> {

    List<ReservationStatus> findByReservationId(Long reservationId);

}
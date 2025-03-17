package roomescape.springboot.core.api.reservation.tool;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import roomescape.springboot.core.api.reservation.domain.Reservation;
import roomescape.springboot.core.api.reservation_time.domain.ReservationTime;
import roomescape.springboot.db.core.reservation.ReservationEntity;
import roomescape.springboot.db.core.reservation.ReservationRepository;
import roomescape.springboot.db.core.reservation_time.ReservationTimeEntity;
import roomescape.springboot.db.core.reservation_time.ReservationTimeRepository;

@Component
@RequiredArgsConstructor
public class ReservationReader {

    private final ReservationRepository reservationRepository;
    private final ReservationTimeRepository reservationTimeRepository;

    public List<Reservation> findAll() {
        List<ReservationEntity> reservationEntities = reservationRepository.findAll();
        return reservationEntities.stream()
                .map(reservationEntity -> new Reservation(reservationEntity.getName(), reservationEntity.getDate(),
                        getTime(reservationEntity.getTimeId()), reservationEntity.getId()))
                .toList();
    }

    private ReservationTime getTime(Long timeId) {
        ReservationTimeEntity reservationTimeEntity = reservationTimeRepository.findById(timeId);
        return new ReservationTime(reservationTimeEntity.getStartAt(), reservationTimeEntity.getId());
    }
}

package roomescape.springboot.core.api.reservation.tool;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import roomescape.springboot.core.api.reservation.domain.Reservation;
import roomescape.springboot.core.api.reservation.dto.ReservationRequest;
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
                        getTime(reservationEntity.getReservationTime().getId()), reservationEntity.getId()))
                .toList();
    }

    private ReservationTime getTime(Long timeId) {
        ReservationTimeEntity reservationTimeEntity = reservationTimeRepository.findById(timeId)
                .orElseThrow(IllegalArgumentException::new);
        return new ReservationTime(reservationTimeEntity.getStartAt(), reservationTimeEntity.getId());
    }

    public boolean existsByReservationTime(Long timeId) {
        List<ReservationEntity> reservationEntities = reservationRepository.findByReservationTime(timeId);
        return !reservationEntities.isEmpty();
    }

    public boolean existsByReservation(ReservationRequest reservationRequest) {
        Optional<ReservationEntity> reservationEntity = reservationRepository.findByReservation(
                reservationRequest.date(), reservationRequest.timeId()
        );
        return reservationEntity.isPresent();
    }
}

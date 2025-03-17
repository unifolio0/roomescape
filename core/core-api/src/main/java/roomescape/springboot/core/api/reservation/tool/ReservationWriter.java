package roomescape.springboot.core.api.reservation.tool;

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
public class ReservationWriter {

    private final ReservationRepository reservationRepository;
    private final ReservationTimeRepository reservationTimeRepository;

    public Reservation save(ReservationRequest request) {
        ReservationTimeEntity time = reservationTimeRepository.findById(request.timeId());
        ReservationEntity reservationEntity = reservationRepository.save(
                new ReservationEntity(request.name(), request.date(), time.getId()));
        return new Reservation(reservationEntity.getName(), reservationEntity.getDate(),
                new ReservationTime(time.getStartAt(), time.getId()), reservationEntity.getId());
    }

    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }
}

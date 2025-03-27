package roomescape.springboot.core.api.reservationtime.tool;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import roomescape.springboot.core.api.reservationtime.domain.ReservationTime;
import roomescape.springboot.db.core.reservationtime.ReservationTimeEntity;
import roomescape.springboot.db.core.reservationtime.ReservationTimeRepository;

@Component
@RequiredArgsConstructor
public class ReservationTimeReader {

    private final ReservationTimeRepository reservationTimeRepository;

    public List<ReservationTime> findAll() {
        List<ReservationTimeEntity> reservationTimeEntities = reservationTimeRepository.findAll();
        return reservationTimeEntities.stream()
                .map(reservationTimeEntity -> new ReservationTime(reservationTimeEntity.getStartAt(),
                        reservationTimeEntity.getId()))
                .toList();
    }

    public ReservationTime findById(Long id) {
        ReservationTimeEntity reservationTimeEntity = reservationTimeRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        return new ReservationTime(reservationTimeEntity.getStartAt(), reservationTimeEntity.getId());
    }
}

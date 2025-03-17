package roomescape.springboot.core.api.reservation_time.tool;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import roomescape.springboot.core.api.reservation_time.domain.ReservationTime;
import roomescape.springboot.db.core.reservation_time.ReservationTimeEntity;
import roomescape.springboot.db.core.reservation_time.ReservationTimeRepository;

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
}

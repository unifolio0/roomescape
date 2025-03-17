package roomescape.springboot.core.api.reservation_time.tool;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import roomescape.springboot.core.api.reservation_time.domain.ReservationTime;
import roomescape.springboot.core.api.reservation_time.dto.ReservationTimeRequest;
import roomescape.springboot.db.core.reservation_time.ReservationTimeEntity;
import roomescape.springboot.db.core.reservation_time.ReservationTimeRepository;

@Component
@RequiredArgsConstructor
public class ReservationTimeWriter {

    private final ReservationTimeRepository reservationTimeRepository;

    public ReservationTime save(ReservationTimeRequest request) {
        ReservationTimeEntity reservationTimeEntity = reservationTimeRepository.save(
                new ReservationTimeEntity(request.startAt()));
        return new ReservationTime(reservationTimeEntity.getStartAt(), reservationTimeEntity.getId());
    }

    public void deleteById(Long id) {
        reservationTimeRepository.deleteById(id);
    }
}

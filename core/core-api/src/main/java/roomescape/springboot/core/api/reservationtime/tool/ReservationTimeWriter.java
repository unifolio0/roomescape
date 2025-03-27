package roomescape.springboot.core.api.reservationtime.tool;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import roomescape.springboot.core.api.reservationtime.domain.ReservationTime;
import roomescape.springboot.core.api.reservationtime.dto.ReservationTimeRequest;
import roomescape.springboot.db.core.reservationtime.ReservationTimeEntity;
import roomescape.springboot.db.core.reservationtime.ReservationTimeRepository;

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

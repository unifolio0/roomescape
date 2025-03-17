package roomescape.springboot.core.api.reservation_time.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import roomescape.springboot.core.api.reservation_time.dto.ReservationTimeRequest;
import roomescape.springboot.core.api.reservation_time.dto.ResrvationTimeResponse;
import roomescape.springboot.db.core.reservation_time.ReservationTimeEntity;
import roomescape.springboot.db.core.reservation_time.ReservationTimeRepository;

@Service
@RequiredArgsConstructor
public class ReservationTimeService {

    private final ReservationTimeRepository reservationTimeRepository;

    public List<ResrvationTimeResponse> getTimes() {
        List<ReservationTimeEntity> timeEntities = reservationTimeRepository.findAll();
        return timeEntities.stream()
                .map(ResrvationTimeResponse::new)
                .toList();
    }

    public ResrvationTimeResponse save(ReservationTimeRequest reservationTimeRequest) {
        ReservationTimeEntity reservationTimeEntity = reservationTimeRepository.save(new ReservationTimeEntity(
                reservationTimeRequest.startAt()));
        return new ResrvationTimeResponse(reservationTimeEntity);
    }

    public void delete(Long id) {
        reservationTimeRepository.delete(id);
    }
}

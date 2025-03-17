package roomescape.springboot.core.api.reservation_time.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import roomescape.springboot.core.api.reservation_time.domain.ReservationTime;
import roomescape.springboot.core.api.reservation_time.dto.ReservationTimeRequest;
import roomescape.springboot.core.api.reservation_time.dto.ReservationTimeResponse;
import roomescape.springboot.core.api.reservation_time.tool.ReservationTimeReader;
import roomescape.springboot.core.api.reservation_time.tool.ReservationTimeWriter;

@Service
@RequiredArgsConstructor
public class ReservationTimeService {

    private final ReservationTimeReader reservationTimeReader;
    private final ReservationTimeWriter reservationTimeWriter;

    public ReservationTimeResponse save(ReservationTimeRequest reservationTimeRequest) {
        ReservationTime reservationTime = reservationTimeWriter.save(reservationTimeRequest);
        return new ReservationTimeResponse(reservationTime);
    }

    public List<ReservationTimeResponse> findAll() {
        List<ReservationTime> timeEntities = reservationTimeReader.findAll();
        return timeEntities.stream()
                .map(ReservationTimeResponse::new)
                .toList();
    }

    public void delete(Long id) {
        reservationTimeWriter.deleteById(id);
    }
}

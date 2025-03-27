package roomescape.springboot.core.api.reservationtime.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import roomescape.springboot.core.api.reservation.tool.ReservationReader;
import roomescape.springboot.core.api.reservationtime.domain.ReservationTime;
import roomescape.springboot.core.api.reservationtime.dto.ReservationTimeRequest;
import roomescape.springboot.core.api.reservationtime.dto.ReservationTimeResponse;
import roomescape.springboot.core.api.reservationtime.tool.ReservationTimeReader;
import roomescape.springboot.core.api.reservationtime.tool.ReservationTimeWriter;

@Service
@RequiredArgsConstructor
public class ReservationTimeService {

    private final ReservationTimeReader reservationTimeReader;
    private final ReservationTimeWriter reservationTimeWriter;
    private final ReservationReader reservationReader;

    public ReservationTimeResponse save(ReservationTimeRequest reservationTimeRequest) {
        ReservationTime reservationTime = reservationTimeWriter.save(reservationTimeRequest);
        return new ReservationTimeResponse(reservationTime);
    }

    public List<ReservationTimeResponse> findAll() {
        List<ReservationTime> reservationTimes = reservationTimeReader.findAll();
        return reservationTimes.stream()
                .map(ReservationTimeResponse::new)
                .toList();
    }

    public void delete(Long id) {
        if (!reservationReader.existsByReservationTime(id)) {
            throw new IllegalArgumentException("해당 시간의 예약이 존재합니다.");
        }
        reservationTimeWriter.deleteById(id);
    }
}

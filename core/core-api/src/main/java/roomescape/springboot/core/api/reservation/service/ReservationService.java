package roomescape.springboot.core.api.reservation.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import roomescape.springboot.core.api.reservation.domain.Reservation;
import roomescape.springboot.core.api.reservation.dto.ReservationRequest;
import roomescape.springboot.core.api.reservation.dto.ReservationResponse;
import roomescape.springboot.core.api.reservation.tool.ReservationReader;
import roomescape.springboot.core.api.reservation.tool.ReservationWriter;
import roomescape.springboot.core.api.reservation_time.dto.ReservationTimeResponse;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationReader reservationReader;
    private final ReservationWriter reservationWriter;

    public ReservationResponse save(ReservationRequest reservationRequest) {
        Reservation reservation = reservationWriter.save(reservationRequest);
        return new ReservationResponse(reservation, new ReservationTimeResponse(reservation.getReservationTime()));
    }

    public List<ReservationResponse> getReservations() {
        List<Reservation> reservations = reservationReader.findAll();
        return reservations.stream()
                .map(reservation -> new ReservationResponse(reservation,
                        new ReservationTimeResponse(reservation.getReservationTime())))
                .toList();
    }

    public void delete(Long id) {
        reservationWriter.deleteById(id);
    }
}

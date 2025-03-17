package roomescape.springboot.core.api.reservation.dto;

import java.time.LocalDate;
import roomescape.springboot.core.api.reservation.domain.Reservation;
import roomescape.springboot.core.api.reservation_time.dto.ReservationTimeResponse;

public record ReservationResponse(long id, String name, LocalDate date, ReservationTimeResponse time) {

    public ReservationResponse(Reservation reservation, ReservationTimeResponse timeResponse) {
        this(reservation.getSequence(), reservation.getName(), reservation.getDate(), timeResponse);
    }
}

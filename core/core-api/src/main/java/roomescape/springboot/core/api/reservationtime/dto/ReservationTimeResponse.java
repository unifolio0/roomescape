package roomescape.springboot.core.api.reservationtime.dto;

import java.time.LocalTime;
import roomescape.springboot.core.api.reservationtime.domain.ReservationTime;

public record ReservationTimeResponse(long id, LocalTime startAt) {

    public ReservationTimeResponse(ReservationTime reservationTime) {
        this(reservationTime.getSequence(), reservationTime.getStartAt());
    }
}

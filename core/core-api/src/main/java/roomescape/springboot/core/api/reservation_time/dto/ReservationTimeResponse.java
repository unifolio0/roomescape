package roomescape.springboot.core.api.reservation_time.dto;

import java.time.LocalTime;
import roomescape.springboot.core.api.reservation_time.domain.ReservationTime;

public record ReservationTimeResponse(long id, LocalTime startAt) {

    public ReservationTimeResponse(ReservationTime reservationTime) {
        this(reservationTime.getSequence(), reservationTime.getStartAt());
    }
}

package roomescape.springboot.core.api.reservation_time.dto;

import java.time.LocalTime;
import roomescape.springboot.db.core.reservation_time.ReservationTimeEntity;

public record ResrvationTimeResponse(long id, LocalTime startAt) {

    public ResrvationTimeResponse(ReservationTimeEntity reservationTimeEntity) {
        this(reservationTimeEntity.getId(), reservationTimeEntity.getStartAt());
    }
}

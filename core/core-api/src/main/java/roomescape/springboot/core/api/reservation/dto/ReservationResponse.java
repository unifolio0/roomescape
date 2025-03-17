package roomescape.springboot.core.api.reservation.dto;

import java.time.LocalDate;
import roomescape.springboot.core.api.reservation_time.dto.ResrvationTimeResponse;
import roomescape.springboot.db.core.reservation.ReservationEntity;

public record ReservationResponse(long id, String name, LocalDate date, ResrvationTimeResponse time) {

    public ReservationResponse(ReservationEntity reservationEntity, ResrvationTimeResponse time) {
        this(reservationEntity.getId(), reservationEntity.getName(), reservationEntity.getDate(), time);
    }
}

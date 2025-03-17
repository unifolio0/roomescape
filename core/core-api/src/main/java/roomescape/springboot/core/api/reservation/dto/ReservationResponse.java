package roomescape.springboot.core.api.reservation.dto;

import java.time.LocalDate;
import roomescape.springboot.core.api.time.dto.TimeResponse;
import roomescape.springboot.db.core.reservation.ReservationEntity;

public record ReservationResponse(long id, String name, LocalDate date, TimeResponse time) {

    public ReservationResponse(ReservationEntity reservationEntity, TimeResponse time) {
        this(reservationEntity.getId(), reservationEntity.getName(), reservationEntity.getDate(), time);
    }
}

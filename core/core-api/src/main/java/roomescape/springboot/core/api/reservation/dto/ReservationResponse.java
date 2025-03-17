package roomescape.springboot.core.api.reservation.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import roomescape.springboot.db.core.reservation.ReservationEntity;

public record ReservationResponse(long id, String name, LocalDate date, LocalTime time) {

    public ReservationResponse(ReservationEntity reservationEntity) {
        this(reservationEntity.getId(), reservationEntity.getName(), reservationEntity.getDate(),
                reservationEntity.getTime());
    }
}

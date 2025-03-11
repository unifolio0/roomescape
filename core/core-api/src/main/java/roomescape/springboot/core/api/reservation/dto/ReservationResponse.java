package roomescape.springboot.core.api.reservation.dto;

import roomescape.springboot.db.core.ReservationEntity;

public record ReservationResponse(long id, String name, String date, String time) {

    public ReservationResponse(ReservationEntity reservationEntity) {
        this(reservationEntity.getId(), reservationEntity.getName(), reservationEntity.getDate(),
                reservationEntity.getTime());
    }
}

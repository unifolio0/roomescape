package roomescape.springboot.db.core.reservation;

import java.time.LocalDate;
import lombok.Getter;
import roomescape.springboot.db.core.reservation_time.ReservationTimeEntity;

@Getter
public class ReservationEntity {

    private Long id;
    private String name;
    private LocalDate date;
    private ReservationTimeEntity reservationTime;

    public ReservationEntity(Long id, String name, LocalDate date, ReservationTimeEntity reservationTime) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.reservationTime = reservationTime;
    }

    public ReservationEntity(String name, LocalDate date, ReservationTimeEntity reservationTime) {
        this(null, name, date, reservationTime);
    }
}

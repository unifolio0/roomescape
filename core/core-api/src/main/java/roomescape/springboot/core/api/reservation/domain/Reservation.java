package roomescape.springboot.core.api.reservation.domain;

import java.time.LocalDate;
import lombok.Getter;
import roomescape.springboot.core.api.reservation_time.domain.ReservationTime;

@Getter
public class Reservation {

    private final String name;
    private final LocalDate date;
    private final ReservationTime reservationTime;
    private final long sequence;

    public Reservation(String name, LocalDate date, ReservationTime reservationTime, long sequence) {
        this.name = name;
        this.date = date;
        this.reservationTime = reservationTime;
        this.sequence = sequence;
    }
}

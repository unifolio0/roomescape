package roomescape.springboot.db.core.reservation;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Getter;

@Getter
public class ReservationEntity {

    private Long id;
    private String name;
    private LocalDate date;
    private LocalTime time;

    public ReservationEntity(Long id, String name, LocalDate date, LocalTime time) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public ReservationEntity(String name, LocalDate date, LocalTime time) {
        this(null, name, date, time);
    }
}

package roomescape.springboot.db.core.reservation;

import java.time.LocalDate;
import lombok.Getter;

@Getter
public class ReservationEntity {

    private Long id;
    private String name;
    private LocalDate date;
    private Long timeId;

    public ReservationEntity(Long id, String name, LocalDate date, Long timeId) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.timeId = timeId;
    }

    public ReservationEntity(String name, LocalDate date, Long timeId) {
        this(null, name, date, timeId);
    }
}

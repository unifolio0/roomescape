package roomescape.springboot.db.core.reservation_time;

import java.time.LocalTime;
import lombok.Getter;

@Getter
public class ReservationTimeEntity {

    private Long id;
    private LocalTime startAt;

    public ReservationTimeEntity(Long id, LocalTime startAt) {
        this.id = id;
        this.startAt = startAt;
    }

    public ReservationTimeEntity(LocalTime startAt) {
        this(null, startAt);
    }
}

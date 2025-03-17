package roomescape.springboot.core.api.reservation_time.domain;

import java.time.LocalTime;
import lombok.Getter;

@Getter
public class ReservationTime {

    private final LocalTime startAt;
    private final long sequence;

    public ReservationTime(LocalTime startAt, long sequence) {
        this.startAt = startAt;
        this.sequence = sequence;
    }
}

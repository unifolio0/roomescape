package roomescape.springboot.db.core.time;

import java.time.LocalTime;
import lombok.Getter;

@Getter
public class TimeEntity {

    private Long id;
    private LocalTime startAt;

    public TimeEntity(Long id, LocalTime startAt) {
        this.id = id;
        this.startAt = startAt;
    }

    public TimeEntity(LocalTime startAt) {
        this(null, startAt);
    }
}

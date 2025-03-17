package roomescape.springboot.core.api.time.dto;

import java.time.LocalTime;
import roomescape.springboot.db.core.time.TimeEntity;

public record TimeResponse(long id, LocalTime startAt) {

    public TimeResponse(TimeEntity timeEntity) {
        this(timeEntity.getId(), timeEntity.getStartAt());
    }
}

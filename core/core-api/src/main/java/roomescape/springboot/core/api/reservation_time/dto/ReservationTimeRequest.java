package roomescape.springboot.core.api.reservation_time.dto;

import java.time.LocalTime;

public record ReservationTimeRequest(LocalTime startAt) {
}

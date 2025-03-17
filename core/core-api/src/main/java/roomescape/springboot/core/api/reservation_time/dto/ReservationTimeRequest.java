package roomescape.springboot.core.api.reservation_time.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalTime;

public record ReservationTimeRequest(
        @NotNull
        @NotBlank
        LocalTime startAt
) {
}

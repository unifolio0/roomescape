package roomescape.springboot.core.api.reservationtime.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalTime;

public record ReservationTimeRequest(
        @NotNull
        @NotBlank
        LocalTime startAt
) {
}

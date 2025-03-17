package roomescape.springboot.core.api.reservation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record ReservationRequest(
        @NotNull
        @NotBlank
        String name,

        @NotNull
        @NotBlank
        LocalDate date,

        @NotNull
        @NotBlank
        Long timeId
) {
}

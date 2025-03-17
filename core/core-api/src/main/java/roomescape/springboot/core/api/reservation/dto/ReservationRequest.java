package roomescape.springboot.core.api.reservation.dto;

import java.time.LocalDate;

public record ReservationRequest(String name, LocalDate date, Long timeId) {
}

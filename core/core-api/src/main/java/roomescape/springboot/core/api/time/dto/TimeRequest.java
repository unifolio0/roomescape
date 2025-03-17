package roomescape.springboot.core.api.time.dto;

import java.time.LocalTime;

public record TimeRequest(LocalTime startAt) {
}

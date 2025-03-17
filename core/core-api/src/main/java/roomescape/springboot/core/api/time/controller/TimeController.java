package roomescape.springboot.core.api.time.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import roomescape.springboot.core.api.time.dto.TimeRequest;
import roomescape.springboot.core.api.time.dto.TimeResponse;
import roomescape.springboot.core.api.time.service.TimeService;

@RestController
@RequiredArgsConstructor
public class TimeController {

    private final TimeService timeService;

    @GetMapping("/times")
    public ResponseEntity<List<TimeResponse>> getReservations() {
        List<TimeResponse> timeResponses = timeService.getTimes();

        return ResponseEntity.ok(timeResponses);
    }

    @PostMapping("/times")
    public ResponseEntity<TimeResponse> saveReservation(@RequestBody TimeRequest timeRequest) {
        TimeResponse timeResponse = timeService.save(timeRequest);

        return ResponseEntity.ok(timeResponse);
    }

    @DeleteMapping("/times/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        timeService.delete(id);

        return ResponseEntity.noContent().build();
    }
}

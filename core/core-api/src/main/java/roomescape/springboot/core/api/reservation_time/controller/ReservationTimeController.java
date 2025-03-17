package roomescape.springboot.core.api.reservation_time.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import roomescape.springboot.core.api.reservation_time.dto.ReservationTimeRequest;
import roomescape.springboot.core.api.reservation_time.dto.ReservationTimeResponse;
import roomescape.springboot.core.api.reservation_time.service.ReservationTimeService;

@RestController
@RequiredArgsConstructor
public class ReservationTimeController {

    private final ReservationTimeService reservationTimeService;

    @GetMapping("/times")
    public ResponseEntity<List<ReservationTimeResponse>> getReservations() {
        List<ReservationTimeResponse> resrvationTimeRespons = reservationTimeService.findAll();

        return ResponseEntity.ok(resrvationTimeRespons);
    }

    @PostMapping("/times")
    public ResponseEntity<ReservationTimeResponse> saveReservation(
            @RequestBody ReservationTimeRequest reservationTimeRequest) {
        ReservationTimeResponse reservationTimeResponse = reservationTimeService.save(reservationTimeRequest);

        return ResponseEntity.ok(reservationTimeResponse);
    }

    @DeleteMapping("/times/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationTimeService.delete(id);

        return ResponseEntity.noContent().build();
    }
}

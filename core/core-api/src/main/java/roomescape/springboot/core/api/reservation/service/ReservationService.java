package roomescape.springboot.core.api.reservation.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import roomescape.springboot.core.api.reservation.dto.ReservationRequest;
import roomescape.springboot.core.api.reservation.dto.ReservationResponse;
import roomescape.springboot.db.core.ReservationEntity;
import roomescape.springboot.db.core.ReservationRepository;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public List<ReservationResponse> getReservations() {
        List<ReservationEntity> reservationEntities = reservationRepository.findAll();
        return reservationEntities.stream()
                .map(ReservationResponse::new)
                .toList();
    }

    public ReservationResponse save(ReservationRequest reservationRequest) {
        ReservationEntity reservationEntity = reservationRepository.save(
                new ReservationEntity(reservationRequest.name(), reservationRequest.date(), reservationRequest.time()));
        return new ReservationResponse(reservationEntity);
    }

    public void delete(Long id) {
        reservationRepository.delete(id);
    }
}

package roomescape.springboot.core.api.reservation.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import roomescape.springboot.core.api.reservation.dto.ReservationRequest;
import roomescape.springboot.core.api.reservation.dto.ReservationResponse;
import roomescape.springboot.core.api.reservation_time.dto.ResrvationTimeResponse;
import roomescape.springboot.db.core.reservation.ReservationEntity;
import roomescape.springboot.db.core.reservation.ReservationRepository;
import roomescape.springboot.db.core.reservation_time.ReservationTimeEntity;
import roomescape.springboot.db.core.reservation_time.ReservationTimeRepository;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationTimeRepository reservationTimeRepository;

    public List<ReservationResponse> getReservations() {
        List<ReservationEntity> reservationEntities = reservationRepository.findAll();
        return reservationEntities.stream()
                .map(reservationEntity -> new ReservationResponse(reservationEntity,
                        getTimeResponse(reservationEntity.getTimeId())))
                .toList();
    }

    public ReservationResponse save(ReservationRequest reservationRequest) {
        ReservationEntity reservationEntity = reservationRepository.save(
                new ReservationEntity(reservationRequest.name(), reservationRequest.date(),
                        reservationRequest.timeId()));
        return new ReservationResponse(reservationEntity, getTimeResponse(reservationEntity.getTimeId()));
    }

    public void delete(Long id) {
        reservationRepository.delete(id);
    }

    private ResrvationTimeResponse getTimeResponse(Long timeId) {
        ReservationTimeEntity reservationTimeEntity = reservationTimeRepository.findById(timeId);
        return new ResrvationTimeResponse(reservationTimeEntity);
    }
}

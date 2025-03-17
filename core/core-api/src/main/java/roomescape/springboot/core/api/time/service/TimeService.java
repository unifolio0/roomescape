package roomescape.springboot.core.api.time.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import roomescape.springboot.core.api.time.dto.TimeRequest;
import roomescape.springboot.core.api.time.dto.TimeResponse;
import roomescape.springboot.db.core.time.TimeEntity;
import roomescape.springboot.db.core.time.TimeRepository;

@Service
@RequiredArgsConstructor
public class TimeService {

    private final TimeRepository timeRepository;

    public List<TimeResponse> getTimes() {
        List<TimeEntity> timeEntities = timeRepository.findAll();
        return timeEntities.stream()
                .map(TimeResponse::new)
                .toList();
    }

    public TimeResponse save(TimeRequest timeRequest) {
        TimeEntity timeEntity = timeRepository.save(new TimeEntity(timeRequest.startAt()));
        return new TimeResponse(timeEntity);
    }

    public void delete(Long id) {
        timeRepository.delete(id);
    }
}

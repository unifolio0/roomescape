package roomescape.springboot.db.core.reservation_time;

import java.sql.PreparedStatement;
import java.sql.Time;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReservationTimeRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<ReservationTimeEntity> findAll() {
        String sql = "select id, start_at from reservation_time";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new ReservationTimeEntity(
                rs.getLong("id"),
                rs.getTime("start_at").toLocalTime()
        ));
    }

    public ReservationTimeEntity findById(Long id) {
        String sql = "select id, start_at from reservation_time where id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new ReservationTimeEntity(
                rs.getLong("id"),
                rs.getTime("start_at").toLocalTime()
        ), id);
    }

    public ReservationTimeEntity save(ReservationTimeEntity reservationTimeEntity) {
        String sql = "insert into reservation_time (start_at) values (?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setTime(1, Time.valueOf(reservationTimeEntity.getStartAt()));
            return ps;
        }, keyHolder);
        return new ReservationTimeEntity(Objects.requireNonNull(keyHolder.getKey()).longValue(),
                reservationTimeEntity.getStartAt());
    }

    public void delete(Long id) {
        String sql = "delete from reservation_time where id = ?";
        jdbcTemplate.update(sql, id);
    }
}

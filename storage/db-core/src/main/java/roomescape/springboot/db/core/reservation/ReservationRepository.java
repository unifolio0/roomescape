package roomescape.springboot.db.core.reservation;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReservationRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<ReservationEntity> findAll() {
        String sql = """
                SELECT
                    r.id AS reservation_id,
                    r.name,
                    r.date,
                    t.id AS time_id,
                    t.start_at AS time_value
                FROM reservation as r
                INNER JOIN reservation_time AS t
                ON r.time_id = t.id
                """;
        return jdbcTemplate.query(sql, (rs, rowNum) -> new ReservationEntity(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getDate("date").toLocalDate(),
                rs.getLong("time_id")
        ));
    }

    public ReservationEntity save(ReservationEntity reservationEntity) {
        String sql = "insert into reservation (name, date, time_id) values (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, reservationEntity.getName());
            ps.setDate(2, Date.valueOf(reservationEntity.getDate()));
            ps.setLong(3, reservationEntity.getTimeId());
            return ps;
        }, keyHolder);
        return new ReservationEntity(Objects.requireNonNull(keyHolder.getKey()).longValue(),
                reservationEntity.getName(), reservationEntity.getDate(), reservationEntity.getTimeId());
    }

    public void deleteById(Long id) {
        String sql = "delete from reservation where id = ?";
        jdbcTemplate.update(sql, id);
    }
}

package roomescape.springboot.db.core;

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
        String sql = "select id, name, date, time from reservation";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new ReservationEntity(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("date"),
                rs.getString("time")
        ));
    }

    public ReservationEntity save(ReservationEntity reservationEntity) {
        String sql = "insert into reservation (name, date, time) values (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, reservationEntity.getName());
            ps.setString(2, reservationEntity.getDate());
            ps.setString(3, reservationEntity.getTime());
            return ps;
        }, keyHolder);
        return new ReservationEntity(Objects.requireNonNull(keyHolder.getKey()).longValue(),
                reservationEntity.getName(), reservationEntity.getDate(), reservationEntity.getTime());
    }

    public void delete(Long id) {
        String sql = "delete from reservation where id = ?";
        jdbcTemplate.update(sql, id);
    }
}

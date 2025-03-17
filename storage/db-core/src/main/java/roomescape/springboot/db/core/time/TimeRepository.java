package roomescape.springboot.db.core.time;

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
public class TimeRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<TimeEntity> findAll() {
        String sql = "select id, start_at from time";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new TimeEntity(
                rs.getLong("id"),
                rs.getTime("start_at").toLocalTime()
        ));
    }

    public TimeEntity save(TimeEntity timeEntity) {
        String sql = "insert into time (start_at) values (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setTime(1, Time.valueOf(timeEntity.getStartAt()));
            return ps;
        }, keyHolder);
        return new TimeEntity(Objects.requireNonNull(keyHolder.getKey()).longValue(), timeEntity.getStartAt());
    }

    public void delete(Long id) {
        String sql = "delete from time where id = ?";
        jdbcTemplate.update(sql, id);
    }
}

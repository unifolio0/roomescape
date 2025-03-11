package roomescape.springboot.db.core;

import lombok.Getter;

@Getter
public class ReservationEntity {

    private Long id;
    private String name;
    private String date;
    private String time;

    public ReservationEntity(Long id, String name, String date, String time) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public ReservationEntity(String name, String date, String time) {
        this(null, name, date, time);
    }
}

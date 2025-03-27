package roomescape.springboot.core.api.theme.domain;

import lombok.Getter;

@Getter
public class Theme {

    private final String name;
    private final String description;
    private final String thumbnail;
    private final Long sequence;

    public Theme(String name, String description, String thumbnail, Long sequence) {
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
        this.sequence = sequence;
    }
}

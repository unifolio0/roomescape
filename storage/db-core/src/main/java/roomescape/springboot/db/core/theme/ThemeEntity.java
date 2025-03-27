package roomescape.springboot.db.core.theme;

import lombok.Getter;

@Getter
public class ThemeEntity {

    private Long id;
    private String name;
    private String description;
    private String thumbnail;

    public ThemeEntity(Long id, String name, String description, String thumbnail) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
    }

    public ThemeEntity(String name, String description, String thumbnail) {
        this(null, name, description, thumbnail);
    }
}

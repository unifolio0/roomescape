package roomescape.springboot.core.api.theme.dto;

import roomescape.springboot.core.api.theme.domain.Theme;

public record ThemeResponse(long id, String name, String description, String thumbnail) {

    public ThemeResponse(Theme theme) {
        this(theme.getSequence(), theme.getName(), theme.getDescription(), theme.getThumbnail());
    }
}

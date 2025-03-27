package roomescape.springboot.core.api.theme.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import roomescape.springboot.core.api.theme.domain.Theme;
import roomescape.springboot.core.api.theme.dto.ThemeResponse;
import roomescape.springboot.core.api.theme.tool.ThemeReader;

@Service
@RequiredArgsConstructor
public class ThemeService {

    private final ThemeReader themeReader;

    public List<ThemeResponse> findAll() {
        List<Theme> themes = themeReader.findAll();
        return themes.stream()
                .map(ThemeResponse::new)
                .toList();
    }
}

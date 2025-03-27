package roomescape.springboot.core.api.theme.tool;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import roomescape.springboot.core.api.theme.domain.Theme;
import roomescape.springboot.db.core.theme.ThemeEntity;
import roomescape.springboot.db.core.theme.ThemeRepository;

@Component
@RequiredArgsConstructor
public class ThemeReader {

    private final ThemeRepository themeRepository;

    public List<Theme> findAll() {
        List<ThemeEntity> themeEntities = themeRepository.findAll();
        return themeEntities.stream()
                .map(themeEntity -> new Theme(
                        themeEntity.getName(),
                        themeEntity.getDescription(),
                        themeEntity.getThumbnail(),
                        themeEntity.getId()
                ))
                .toList();
    }
}

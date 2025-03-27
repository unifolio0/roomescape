package roomescape.springboot.core.api.theme.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import roomescape.springboot.core.api.theme.dto.ThemeResponse;
import roomescape.springboot.core.api.theme.service.ThemeService;

@RestController
@RequiredArgsConstructor
public class ThemeController {

    private final ThemeService themeService;

    @GetMapping("/themes")
    public ResponseEntity<List<ThemeResponse>> getThemes() {
        List<ThemeResponse> themeResponses = themeService.findAll();
        return ResponseEntity.ok(themeResponses);
    }
}

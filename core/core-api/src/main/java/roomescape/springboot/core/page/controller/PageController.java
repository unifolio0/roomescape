package roomescape.springboot.core.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/admin")
    public String adminPage() {
        return "admin/index";
    }

    @GetMapping("/admin/reservation")
    public String adminReservationPage() {
        return "admin/reservation-legacy";
    }

    @GetMapping("/admin/time")
    public String adminTimePage() {
        return "admin/time";
    }
}

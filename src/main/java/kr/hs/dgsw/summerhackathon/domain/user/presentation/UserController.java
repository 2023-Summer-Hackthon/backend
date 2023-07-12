package kr.hs.dgsw.summerhackathon.domain.user.presentation;

import kr.hs.dgsw.summerhackathon.domain.user.presentation.dto.UserListResponse;
import kr.hs.dgsw.summerhackathon.domain.user.service.QueryRandomUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {

    private final QueryRandomUserService queryRandomUserService;

    @GetMapping("/random")
    public List<UserListResponse> getRandomUserList() {
        return queryRandomUserService.execute();
    }

}

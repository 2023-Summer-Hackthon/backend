package kr.hs.dgsw.summerhackathon.domain.user.presentation;

import kr.hs.dgsw.summerhackathon.domain.user.presentation.dto.request.CreateUserRequest;
import kr.hs.dgsw.summerhackathon.domain.user.presentation.dto.request.LoginUserRequest;
import kr.hs.dgsw.summerhackathon.domain.user.service.CommandUserService;
import kr.hs.dgsw.summerhackathon.domain.user.service.LoginUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final CommandUserService commandUserService;

    private final LoginUserService loginUserService;

    @PostMapping("/create")
    public void createUser(CreateUserRequest request) {
        commandUserService.createUser(request);
    }

    @PostMapping("/login")
    public void loginUser(LoginUserRequest request) {
        loginUserService.execute(request);
    }
}

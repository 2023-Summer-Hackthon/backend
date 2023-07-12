package kr.hs.dgsw.summerhackathon.domain.ask.presentation;

import kr.hs.dgsw.summerhackathon.domain.ask.presentation.dto.request.CreateAskRequest;
import kr.hs.dgsw.summerhackathon.domain.ask.service.RegisterAskService;
import kr.hs.dgsw.summerhackathon.domain.user.domain.User;
import kr.hs.dgsw.summerhackathon.global.annotation.AuthGuard;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ask")
public class AskController {

    private final RegisterAskService registerAskService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @AuthGuard
    public void registerAsk(
            @RequestBody CreateAskRequest request,
            @RequestAttribute User user
    ) {
        registerAskService.execute(request, user);
    }





}

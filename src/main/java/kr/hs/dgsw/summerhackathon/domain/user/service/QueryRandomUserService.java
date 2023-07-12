package kr.hs.dgsw.summerhackathon.domain.user.service;

import kr.hs.dgsw.summerhackathon.domain.user.domain.User;
import kr.hs.dgsw.summerhackathon.domain.user.domain.repository.UserRepository;
import kr.hs.dgsw.summerhackathon.domain.user.presentation.dto.UserListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryRandomUserService {
    private final UserRepository userRepository;

    public List<UserListResponse> execute() {
        List<User> userList = userRepository.findRandom();
        return userList.stream().map(
                it -> new UserListResponse(it.getId(), it.getName(), it.getGender().getValue(), it.getNationality())
        ).collect(Collectors.toList());
    }
}

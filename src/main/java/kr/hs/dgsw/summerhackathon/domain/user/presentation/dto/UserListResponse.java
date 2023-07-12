package kr.hs.dgsw.summerhackathon.domain.user.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserListResponse {

    private Long id;
    private String name;
    private String gender;
    private String nationality;

}

package org.cycle_route.back_end.user.web.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.cycle_route.back_end.user.web.enums.Regions;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class SignupDto {

    @Schema(description = "유저 아이디", example = "test")
    private String userid;

    @Schema(description = "유저 비밀번호", example = "test")
    private String userPwd;

    @Schema(description = "유저 이름", example = "홍길동")
    private String name;

    @Schema(description = "활동 지역", example = "경기")
    private Regions region;
}

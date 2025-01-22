package org.cycle_route.back_end.user.web.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.cycle_route.back_end.global.web.entity.TimeEntity;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "user_table")
public class UserEntity extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "사용자 고유 ID", example = "1")
    private Long userCid;

    @NotNull
    @Schema(description = "유저 아이디", example = "test")
    @Column(name = "user_id", unique = true)
    private String userId;

    @NotNull
    @Schema(description = "유저 비밀번호", example = "test")
    @Column(name = "user_pwd")
    private String userPwd;

}

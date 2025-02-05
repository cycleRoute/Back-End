package org.cycle_route.back_end.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cycle_route.back_end.user.util.UserValidation;
import org.cycle_route.back_end.user.web.dto.auth.SignupDto;
import org.cycle_route.back_end.user.web.entity.UserEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    // UTIL
    private final UserValidation userValidation;
    private final PasswordEncoder passwordEncoder;


   /**
    * 회원가입
    * @param signupReqDto 가입하는 유저의 정보
    * */
    @Transactional
    public void signup(SignupDto signupReqDto) {
        // 아이디 중복 확인
        idDuplicateTest(signupReqDto.getUserid());

        // 유저 엔티티 생성
        String hashedPwd = passwordEncoder.encode(signupReqDto.getUserPwd());
        UserEntity signupUser = UserEntity.from(signupReqDto, hashedPwd);
        // 프로필 이미지 등록(추후 구현)
    }


    /**
     * 아이디 중복 테스트
     * @param userId 입력한 유저 아이디
     */
    public void idDuplicateTest(String userId) {
        userValidation.validateDuplicateUserId(userId);
    }

}

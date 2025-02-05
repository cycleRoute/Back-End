package org.cycle_route.back_end.user.util;

import lombok.RequiredArgsConstructor;
import org.cycle_route.back_end.global.web.advice.exception.CustomDataIntegrityViolationException;
import org.cycle_route.back_end.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserValidation {
    // REPOSITORY
    private final UserRepository userRepository;

    // UTIL
    private final PasswordEncoder passwordEncoder;

    /**
     * 아이디 중복 확인
     * @param userId 유저가 입력한 아이디
     */
    public void validateDuplicateUserId(String userId) {
        if (userRepository.existsByUserId(userId)) {
            throw new CustomDataIntegrityViolationException("이미 사용중인 아이디 입니다.");
        }
    }

}

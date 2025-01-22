package org.cycle_route.back_end.redis.service;

import lombok.RequiredArgsConstructor;

import org.cycle_route.back_end.global.web.advice.exception.CustomNotFoundException;
import org.cycle_route.back_end.redis.entity.RefreshToken;
import org.cycle_route.back_end.redis.repository.RefreshTokenRepository;
import org.cycle_route.back_end.user.repository.UserRepository;
import org.cycle_route.back_end.user.web.entity.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;

    @Transactional
    public void saveTokenInfo(String id, String refreshToken, String accessToken) {
        UserEntity user = userRepository.findByUserId(id)
                .orElseThrow(() -> new CustomNotFoundException("일치하는 유저가 존재하지 않습니다."));
        refreshTokenRepository.save(new RefreshToken(String.valueOf(user.getUserCid()), refreshToken, accessToken));
    }

    @Transactional
    public void removeTokenInfo(String accessToken) {
        refreshTokenRepository.findByAccessToken(accessToken)
                .ifPresent(refreshToken -> refreshTokenRepository.delete(refreshToken));
    }


}

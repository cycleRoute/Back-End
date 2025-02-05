package org.cycle_route.back_end.user.service;

import lombok.RequiredArgsConstructor;
import org.cycle_route.back_end.user.repository.UserRepository;
import org.cycle_route.back_end.user.web.dto.custom.CustomUserDetailDto;
import org.cycle_route.back_end.user.web.dto.custom.TokenUserDto;
import org.cycle_route.back_end.user.web.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserEntity user = (UserEntity) userRepository.findByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException("일치하는 유저 정보가 존재하지 않습니다. userId = " + userId));

        TokenUserDto userDto = TokenUserDto.toDto(user);

        return new CustomUserDetailDto(userDto);
    }
}

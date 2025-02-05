package org.cycle_route.back_end.user.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cycle_route.back_end.global.web.dto.CommonResponseDto;
import org.cycle_route.back_end.user.service.AuthService;
import org.cycle_route.back_end.user.web.dto.auth.SignupDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
@RequestMapping("/public/auth")
@RequiredArgsConstructor
@Tag(name = "[PUBLIC] 회원관련 API")
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "회원가입", description = "회원가입을 다루는 API입니다.")
    @PostMapping(value = "/signup", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseDto> signup(
            @RequestPart(name = "profileImage", required = false) MultipartFile profileImage,
            @RequestPart(name = "signupInfo") @Parameter(schema = @Schema(type = "string", format = "binary")) SignupDto signupReqDto
    ) {
        log.debug("[AUTH] 회원가입 요청이 들어왔습니다. \n{}", signupReqDto);
        authService.signup(signupReqDto);
        log.debug("[AUTH] 회원가입 성공");

        return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponseDto.createSuccessResponse("회원가입 성공"));

    }

}

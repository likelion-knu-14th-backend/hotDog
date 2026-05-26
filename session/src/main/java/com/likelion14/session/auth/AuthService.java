package com.likelion14.session.auth;

import com.likelion14.session.Dto.user.UserSignUpRequestDto;
import com.likelion14.session.auth.common.JwtTokenProvider;
import com.likelion14.session.auth.dto.LoginRequestDto;
import com.likelion14.session.auth.dto.TokenResponseDto;
import com.likelion14.session.auth.enums.Role;
import com.likelion14.session.entity.User;
import com.likelion14.session.exception.ErrorCode;
import com.likelion14.session.exception.Exception;
import com.likelion14.session.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    public void signup(UserSignUpRequestDto request) {
        // 아이디 중복 검사
        if (userRepository.existsByUserId(request.getUserId())) {
            throw new Exception(ErrorCode.ALREADY_ID);
        }

        User user = new User(request.getUserId(),passwordEncoder.encode(request.getUserPw()), request.getUserName(),
                request.getAge(), request.getPhoneNum(),Role.USER
        );
        userRepository.save(user);
    }
    public TokenResponseDto login(LoginRequestDto request) {
        // 아이디로 회원 조회
        User user = userRepository.findUserByUserId(request.getUserID())
                .orElseThrow(()-> new Exception(ErrorCode.USER_NOT_FOUND));
        // 입력한 비밀번호와 암호화된 비밀번호 비교
        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getUserPw()
        )) {
            throw new Exception(ErrorCode.MISMATCH_PASSWORD);
        }
        String accessToken = jwtTokenProvider.generateToken(user);
        // 사용자 이름과 JWT 반환
        return new TokenResponseDto(
                user.getUserName(),
                accessToken
        );
        // 이후 JWT 발급 예정
    }
}



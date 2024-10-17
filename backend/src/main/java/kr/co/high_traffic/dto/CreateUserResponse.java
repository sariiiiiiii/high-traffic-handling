package kr.co.high_traffic.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import kr.co.high_traffic.entity.User;

public record CreateUserResponse(
        @Schema(description = "생성 응답 아이디", example = "1")
        Long id,
        @Schema(description = "생성 응답 이름", example = "sari123")
        String username,
        @Schema(description = "생성 응답 이메일", example = "sari@example.com")
        String email
) {

    public CreateUserResponse(User user) {
        this(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );
    }
}

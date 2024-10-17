package kr.co.high_traffic.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record CreateUserRequest(
        @Schema(description = "생성 요청 이름", example = "sari", minLength = 3, maxLength = 5)
        String username,

        @Schema(description = "생성 요청 패스워드", example = "sari123", minLength = 8, format = "password")
        String password,

        @Schema(description = "생성 요청 이메일", example = "sari@example.com", format = "email")
        String email
) {
}

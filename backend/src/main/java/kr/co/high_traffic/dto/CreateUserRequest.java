package kr.co.high_traffic.dto;

public record CreateUserRequest(
        String username,
        String password,
        String email
) {
}

package kr.co.high_traffic.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.high_traffic.dto.CreateUserRequest;
import kr.co.high_traffic.dto.CreateUserResponse;
import kr.co.high_traffic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "사용자 관리", description = "사용자 관리와 관련된 API")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "성공"),
        @ApiResponse(responseCode = "400", description = "요청 데이터 오류"),
        @ApiResponse(responseCode = "500", description = "서버 에러")
})
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @Operation(summary = "새로운 사용자 생성",
            description = "요청 객체에 주어진 세부 정보를 사용하여 새 사용자를 생성하는 API")
    @ApiResponse(responseCode = "200", description = "성공적으로 생성된 사용자 정보",
            content = @Content(schema = @Schema(implementation = CreateUserResponse.class)))
    @PostMapping("/signUp")
    public ResponseEntity<CreateUserResponse> createUser(
            @Parameter(description = "생성 요청 객체", required = true) @RequestBody final CreateUserRequest request
    ) {
        return ResponseEntity.ok(userService.createUser(request));
    }

    @Operation(summary = "사용자 삭제",
            description = "요청 아이디를 사용하여 사용자를 삭제하는 API")
    @ApiResponse(responseCode = "200", description = "성공")
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(
            @Parameter(description = "삭제 요청 아이디", required = true) @Schema(description = "삭제 요청 아이디", example = "1", format = "Integer") @PathVariable("userId") final Long userId
    ) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

}

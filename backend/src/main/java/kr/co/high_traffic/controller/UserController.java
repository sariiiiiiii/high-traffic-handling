package kr.co.high_traffic.controller;

import io.swagger.v3.oas.annotations.Parameter;
import kr.co.high_traffic.dto.CreateUserRequest;
import kr.co.high_traffic.entity.User;
import kr.co.high_traffic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(
            @Parameter(description = "User creation request object", required = true) @RequestBody final CreateUserRequest request
    ) {
        return ResponseEntity.ok(userService.createUser(request));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(
            @Parameter(description = "ID of the user to be deleted", required = true) @PathVariable("userId") Long userId
    ) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

}

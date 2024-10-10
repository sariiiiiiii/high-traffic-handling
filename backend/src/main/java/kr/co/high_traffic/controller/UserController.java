package kr.co.high_traffic.controller;

import kr.co.high_traffic.dto.CreateUserRequest;
import kr.co.high_traffic.entity.User;
import kr.co.high_traffic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody final CreateUserRequest request) {
        return ResponseEntity.ok(userService.createUser(request));
    }

}

package kr.co.high_traffic.service;

import kr.co.high_traffic.dto.CreateUserRequest;
import kr.co.high_traffic.dto.CreateUserResponse;
import kr.co.high_traffic.entity.User;
import kr.co.high_traffic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public CreateUserResponse createUser(final CreateUserRequest request) {
        User saveUser = userRepository.save(User.toEntity(request));
        return new CreateUserResponse(saveUser);
    }

    public void deleteUser(final Long userId) {
        userRepository.deleteById(userId);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

}

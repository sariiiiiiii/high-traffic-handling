package kr.co.high_traffic.service;

import kr.co.high_traffic.dto.CreateUserRequest;
import kr.co.high_traffic.entity.User;
import kr.co.high_traffic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(final CreateUserRequest request) {
        User user = User.toEntity(request);
        return userRepository.save(user);
    }

}

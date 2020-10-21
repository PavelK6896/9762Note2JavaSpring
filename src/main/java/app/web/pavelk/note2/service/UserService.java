package app.web.pavelk.note2.service;

import app.web.pavelk.note2.model.User;
import app.web.pavelk.note2.model.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void createUser(UserValidation userValidation) {
        User user = new User();
        user.setUsername(userValidation.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userValidation.getPassword()));
        userRepository.save(user);
    }
}

package com.tur.jusus.graphQL;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.tur.jusus.entity.User;
import com.tur.jusus.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserMutation implements GraphQLMutationResolver {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User writeUser(String login, String password) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername(login);
        user.setPassword(passwordEncoder.encode(password));
        user.setAccountExpired(false);
        user.setAccountLocked(false);
        user.setCredentialsExpired(false);
        user.setEnabled(true);
        return userRepository.save(user);
    }
}

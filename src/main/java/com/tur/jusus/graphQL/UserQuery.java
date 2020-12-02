package com.tur.jusus.graphQL;

import com.tur.jusus.entity.User;
import com.tur.jusus.repository.UserRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@GraphQLApi
public class UserQuery {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GraphQLQuery(name = "users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GraphQLMutation(name = "addUser")
    public User addUser(@GraphQLArgument(name = "login") String login, @GraphQLArgument(name = "password") String password) {
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

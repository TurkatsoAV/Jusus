package com.tur.jusus.graphQL;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.tur.jusus.entity.User;
import com.tur.jusus.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class UserQuery implements GraphQLQueryResolver {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}

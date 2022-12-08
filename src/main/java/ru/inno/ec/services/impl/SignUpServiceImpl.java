package ru.inno.ec.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.inno.ec.dto.UserForm;
import ru.inno.ec.models.User;
import ru.inno.ec.repositories.UsersRepository;
import ru.inno.ec.services.SignUpService;

@RequiredArgsConstructor
@Service
public class SignUpServiceImpl implements SignUpService {

    private final UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserForm userForm) {
        User newUser = User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .state(User.State.CONFIRMED)
                .role(User.Role.USER)
                .age(0)
                .build();

        usersRepository.save(newUser);
    }
}

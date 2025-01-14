package es.ies.puerto.mgs.project.service.rest.impl;
/*
import es.ies.puerto.mgs.project.security.jwt.AuthResponse;
import es.ies.puerto.mgs.project.security.jwt.JwtService;
import es.ies.puerto.mgs.project.security.jwt.LoginRequest;
import es.ies.puerto.mgs.project.security.jwt.RegisterRequest;
import es.ies.puerto.mgs.project.security.jwt.user.Role;
import es.ies.puerto.mgs.project.security.jwt.user.User;
import es.ies.puerto.mgs.project.security.jwt.user.repository.IUserDao;
import lombok.*;
import org.springframework.security.authentication.
AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
*/

//TODO: Implement auth service
public class AuthService {
    /**
    private final IUserDao iUserDao;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login (LoginRequest request){
        return null;
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword()))
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .country(request.getCountry())
                .role(Role.USER)
                .build();

        iUserDao.save(user);

        return AuthResponse.
                .token(jwtService.get(user))
                .build();

    }**/

}

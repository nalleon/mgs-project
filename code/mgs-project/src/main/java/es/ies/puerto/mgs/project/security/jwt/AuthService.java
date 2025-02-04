package es.ies.puerto.mgs.project.security.jwt;


import es.ies.puerto.mgs.project.model.entities.Role;
import es.ies.puerto.mgs.project.model.entities.User;
import es.ies.puerto.mgs.project.service.rest.impl.RoleService;
import es.ies.puerto.mgs.project.service.rest.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


/**
 * @author Nabil Leon Alvarez <@nalleon>
 */

@Service
public class AuthService {
    @Autowired
    private UserService service;

    @Autowired
    private RoleService roleService;


    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * FUnction to register a new user
     * @param username of the user
     * @param password of the user
     * @param email of the user
     * @return true if everything OK, false otherwise
     */
    public boolean register(String username, String password, String email) {
        User user = new User();
        user.setName(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);

        Role role = roleService.getById(2);

        user.setRole(role);

        service.add(user);

        User saved = service.getById(1);
        return saved != null;
    }

    /**
     * Funcion para autenticar un User de cara al login
     * @param username del User
     * @param password del User
     * @return token si la autenticacion fue exitosa, null si algo fue mal
     */
    public String authenticate(String username, String password)  {
        String generateToken = null;
        User user = service.getByName(username);

        System.out.println(user);

        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                generateToken = jwtService.generateToken(user.getName(), user.getRole().getName());
            }
        }

        return generateToken;
    }
}

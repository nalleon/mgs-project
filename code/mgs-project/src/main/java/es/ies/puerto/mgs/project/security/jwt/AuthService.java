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
    /**
     * Properties
     */

    private UserService service;

    private RoleService roleService;

    private JwtService jwtService;


    private PasswordEncoder passwordEncoder;

    /**
     * Setters of the user service
     * @param service of the user
     */
    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    /**
     * Setters of the user service
     * @param roleService of the role
     */
    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * Setters of the user service
     * @param jwtService of the role
     */
    @Autowired
    public void setJwtService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    /**
     * Setters of the user service
     * @param passwordEncoder of the role
     */
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Function to register a new user
     * @param username of the user
     * @param password of the user
     * @param email of the user
     * @return the user if everything OK, null otherwise
     */
    public User register(String username, String password, String email) {
        User user = new User();
        user.setName(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        Role role = roleService.getById(2);
        user.setRole(role);
        service.add(user);

        return service.getByName(username);

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
            System.out.println(password);
            if (passwordEncoder.matches(password, user.getPassword())) {
                generateToken = jwtService.generateToken(user.getName(), user.getRole().getName());
            }
        }

        System.out.println(generateToken);

        return generateToken;
    }
}

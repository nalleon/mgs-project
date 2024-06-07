package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.dto.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nalleon
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String createAuthenticationToken(@RequestBody UserInfo userInfo) {

        return "soy_el_token";
    }
}

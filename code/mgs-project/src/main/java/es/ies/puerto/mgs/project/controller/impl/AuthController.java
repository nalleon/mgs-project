package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.dto.UserInfoDTO;
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
    public String createAuthenticationToken(@RequestBody UserInfoDTO userInfoDTO) {
        return "soy_el_token";
    }

    @PostMapping("/login2")
    public String createAuthenticationToken2() {
        return "soy_el_token2";
    }
}

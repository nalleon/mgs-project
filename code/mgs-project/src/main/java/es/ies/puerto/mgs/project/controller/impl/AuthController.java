package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.dto.UserInfoDTO;
import es.ies.puerto.mgs.project.security.jwt.AuthResponse;
import es.ies.puerto.mgs.project.security.jwt.LoginRequest;
import es.ies.puerto.mgs.project.security.jwt.RegisterRequest;
import es.ies.puerto.mgs.project.service.impl.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nalleon
 */
@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    //private AuthService authService;

   // @PostMapping("/login")
   // public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
  //      return ResponseEntity.ok(authService.login(request));
  //  }

 //   @PostMapping("/register")
   // public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
   //     return ResponseEntity.ok(authService.register(request));
   // }
}

package es.ies.puerto.mgs.project.controller.impl;

import lombok.RequiredArgsConstructor;
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

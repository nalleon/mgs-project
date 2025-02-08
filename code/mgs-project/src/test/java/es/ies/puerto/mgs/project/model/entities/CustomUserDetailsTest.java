package es.ies.puerto.mgs.project.model.entities;

import es.ies.puerto.mgs.project.security.CustomUserDetails;
import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

public class CustomUserDetailsTest extends TestUtilities {

    public static final String USERNAME = "testUser";
    public static final String ROLE = "ROLE_ADMIN";

    CustomUserDetails customUserDetails;

    @BeforeEach
    public void setUp() {
        customUserDetails = new CustomUserDetails(USERNAME, ROLE);
    }

    @Test
    public void getUsernameTest() {
        Assertions.assertEquals(USERNAME, customUserDetails.getUsername(), MESSAGE_ERROR);
    }

    @Test
    public void getAuthoritiesTest() {
        Collection<? extends GrantedAuthority> authorities = customUserDetails.getAuthorities();
        List<GrantedAuthority> expectedAuthorities = List.of(new SimpleGrantedAuthority(ROLE));

        Assertions.assertNotNull(authorities, MESSAGE_ERROR);
        Assertions.assertEquals(1, authorities.size(), MESSAGE_ERROR);
        Assertions.assertTrue(authorities.containsAll(expectedAuthorities), MESSAGE_ERROR);
    }

    @Test
    public void getPasswordTest() {
        Assertions.assertNull(customUserDetails.getPassword(), MESSAGE_ERROR);
    }

}

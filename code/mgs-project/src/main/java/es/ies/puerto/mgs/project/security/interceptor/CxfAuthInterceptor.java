package es.ies.puerto.mgs.project.security.interceptor;

import es.ies.puerto.mgs.project.repository.jpa.dao.IDaoUser;
import es.ies.puerto.mgs.project.security.jwt.JwtService;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

public class CxfAuthInterceptor extends AbstractPhaseInterceptor<Message> {

    /**
     * Properties
     */
    @Autowired
    private JwtService jwtTokenManager;
    @Autowired
    private IDaoUser usuarioRepository;


    /**
     * Default constructor of the class
     */
    public CxfAuthInterceptor() {
        super(Phase.PRE_INVOKE);
    }


    @Override
    public void handleMessage(Message message) throws Fault {
        Map<String, List<String>> protocolHeaders = (Map<String, List<String>>) message.get(Message.PROTOCOL_HEADERS);

        if (protocolHeaders != null && protocolHeaders.containsKey("Authorization")) {
            List<String> authorizationHeaders = protocolHeaders.get("Authorization");

            if (authorizationHeaders != null && !authorizationHeaders.isEmpty()) {
                String authHeader = authorizationHeaders.get(0);

                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    String token = authHeader.substring(7);
                    Map<String, String> mapInfoToken = jwtTokenManager.validateAndGetClaims(token);

                    final String username = mapInfoToken.get("username");
                    final String role = mapInfoToken.get("role");

                }

                // TODO: Se debe de realizar la autilizacion del tocken
            }
        } else {
            throw new SecurityException("No se han incluido cabeceras de seguridad");
        }
    }
}

package br.dev.gbrl.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.BCrypt.Result;
import br.dev.gbrl.todolist.Constants;
import br.dev.gbrl.todolist.user.IUserRepository;
import br.dev.gbrl.todolist.user.UserModel;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//CERT CODE = CAFEZINHO

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    private String AUTH_TYPE = "Basic";
    private String AUTH_HEADER = "Authorization";
    private String CREDENTIALS_CHAR_SPLIT = ":";

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        var serverlPath = request.getServletPath();

        if (serverlPath.startsWith("/tasks/")) {
            String authorization = request.getHeader(AUTH_HEADER);
            String encodedAuth = authorization.substring(AUTH_TYPE.length()).trim();
            String decodedAuthorization = new String(Base64.getDecoder().decode(encodedAuth));
            String[] credentials = decodedAuthorization.split(CREDENTIALS_CHAR_SPLIT);

            String username = credentials[0];
            String password = credentials[0];

            UserModel user = this.userRepository.findByUsername(username);

            if (user == null) {
                response.sendError(HttpStatus.UNAUTHORIZED.value());
            } else {
                Result passwordResult = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
                if (passwordResult.verified) {
                    request.setAttribute(Constants.USER_ID_KEY, user.getUuid());
                    filterChain.doFilter(request, response);
                } else {
                    response.sendError(HttpStatus.UNAUTHORIZED.value());
                }
            }

        } else {
            filterChain.doFilter(request, response);
        }
    }
}

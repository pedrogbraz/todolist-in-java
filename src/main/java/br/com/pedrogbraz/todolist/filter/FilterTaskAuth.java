package br.com.pedrogbraz.todolist.filter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.pedrogbraz.todolist.user.IUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;
import java.util.Objects;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var servletPath = request.getServletPath();

        if (servletPath.equals("/tasks/")) {
            // Pegar a autenticação (usuário, senha)
            var authorization = request.getHeader("Authorization");

            var authEncoded = authorization.substring("Basic".length()).trim(); // Irá pegar a palavra "basic" e calcular quantos caracteres ela possui que no caso é 5, e irá remover tudo isso, restando somente a senha criptografada

            byte[] authDecode = Base64.getDecoder().decode(authEncoded);

            var authString = new String(authDecode); // Convertendo ele para string

            String[] credentials = authString.split(":"); // Irá separar o username e o password dentro de uma array
            // = ["pedrogbraz", "PedroBraZ321"]
            String username = credentials[0];
            String password = credentials[1];
            // Validar o usuário
            var user = this.userRepository.findByUsername(username);
            if (user == null) {
                response.sendError(401);
            } else {
                // Validar a senha
                var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
                if (passwordVerify.verified) {
                    request.setAttribute("idUser", user.getId());
                    filterChain.doFilter(request, response);
                } else {
                    response.sendError(401);
                }
                // Segue viagem

            }
        } else {
            filterChain.doFilter(request, response);
        }
    }
}

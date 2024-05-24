package br.com.pedrogbraz.todolist.filter;

import org.springframework.stereotype.Component;
import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@Component
public class FilterTaskAuth implements Filter{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Executar alguma ação

        System.out.println("Chegou no filtro");
        chain.doFilter(request, response);
    }
}

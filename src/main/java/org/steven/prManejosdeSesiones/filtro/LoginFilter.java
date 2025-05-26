package org.steven.prManejosdeSesiones.filtro;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.steven.prManejosdeSesiones.services.LoginService;
import org.steven.prManejosdeSesiones.services.LoginServiceSessionImplement;

import java.io.IOException;
import java.util.Optional;
@WebFilter({"/productos","/agregar-carro"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LoginService service = new LoginServiceSessionImplement();
        Optional<String> username = service.getUserName((HttpServletRequest) servletRequest );
        // realizo una condicional para ver si esta presente el nombre del usuario
        if (username.isPresent()) {
            filterChain.doFilter(servletRequest, servletResponse);

        }else{
            ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no estas autorizado para ingresar a esta pagina");

        }
    }
}

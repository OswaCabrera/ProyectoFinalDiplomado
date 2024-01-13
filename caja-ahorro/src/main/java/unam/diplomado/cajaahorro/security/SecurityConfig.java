package unam.diplomado.cajaahorro.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import unam.diplomado.cajaahorro.usuario.domain.Usuario;
import unam.diplomado.cajaahorro.usuario.repository.UsuarioRepository;

import java.util.Optional;

@Configuration
public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UsuarioRepository usuarioRepository) {
        return username -> {
            Optional<Usuario> usuario = usuarioRepository.findByEmail(username);
            System.out.println("usuario: " + usuario);
            if (usuario.isPresent()) {
                return usuario.get();
            }
            throw new UsernameNotFoundException(
                    "Usuario: " + username + " no encontrado");
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/prestamo/**").hasRole("ADMIN")
                .requestMatchers("/transaccion/**").hasRole("ADMIN")
                .requestMatchers("/estadisticas/**").hasRole("ADMIN")
                .requestMatchers("/usuario/**").hasRole("CLIENTE")
                .requestMatchers("/", "/**").permitAll()
                .and()
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")
                                .loginProcessingUrl("/autenticacion")
                                .usernameParameter("usuario")
                                .passwordParameter("pwd")
                                .defaultSuccessUrl("/usuario/perfil", true));
        return http.build();
    }


}

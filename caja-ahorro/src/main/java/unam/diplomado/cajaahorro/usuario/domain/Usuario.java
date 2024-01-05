package unam.diplomado.cajaahorro.usuario.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Integer id;
    private String nombre;
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    private String email;
    private String password;
    @Column(name = "numero_telefonico")
    private String numeroTelefonico;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

    //Transient
    @Transient
    @OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY)
    private Cuenta cuenta;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.email.contains("@caja.ahorro.com")) {
            return Arrays.asList(
                    new SimpleGrantedAuthority("ROLE_CLIENTE"),
                    new SimpleGrantedAuthority("ROLE_ADMIN")
            );
        }
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_CLIENTE"));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

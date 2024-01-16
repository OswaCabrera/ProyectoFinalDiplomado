package unam.diplomado.cajaahorro.usuario.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Nombre no debe ser vació")
    private String nombre;
    @NotBlank(message = "Apellido paterno no debe ser vació")
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @NotBlank(message = "Apellido materno no debe ser vació")
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    private String fotografia;
    @NotBlank(message = "Correo no debe ser vació")
    @Email
    private String email;
    @NotBlank(message = "Contraseña no debe ser vació")
    private String password;
    @NotBlank(message = "Teléfono no debe ser vació")
    @Size(min=10,max=10,message = "Teléfono debe ser de 10 dígitos")
    @Pattern(regexp = "55[0-9]{8,8}")
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
        if (this.email.equals("oswaldo121oswaldo@gmail.com")) {
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

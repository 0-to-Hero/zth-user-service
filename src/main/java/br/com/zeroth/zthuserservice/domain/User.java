package br.com.zeroth.zthuserservice.domain;

import br.com.zeroth.zthuserservice.config.PasswordConfig;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
public class User implements Serializable {

    public User(Long id, String name, String password, String email, String latitude, String longitude) {
        this.id = id;
        this.name = name;
        this.password = new PasswordConfig().encoder().encode(password);
        this.email = email;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String email;
    private String latitude;
    private String longitude;

}

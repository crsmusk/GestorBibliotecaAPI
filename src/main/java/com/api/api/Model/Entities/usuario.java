package com.api.api.Model.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Negative;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name")
    private String userName;
    private String password;
    @Column(name = "is_enable")
    private boolean isEnable=true;
    @Column(name = "account_no_locked")
    private boolean accountNoLocked=true;
    @Column(name = "account_no_expired")
    private boolean accountNoExpired=true;
    @Column(name = "credential_no_expired")
    private boolean credentialNoExpired=true;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(
            name = "usuario_rol",joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    List<rol> roles;

}

package dev.juviscript.klutchgaming.users.model;

import dev.juviscript.klutchgaming.auth.model.Role;
import dev.juviscript.klutchgaming.common.BaseEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Table(name = "users")
@EqualsAndHashCode(callSuper = true)
@Data
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    private String passwordHash;

    @Nullable
    private String phoneNumber;

    @OneToMany(mappedBy = "user")
    private List<Address> addresses;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role;
}

package com.deltatech.diligencetech.platform.iam.domain.model.entities;

import com.deltatech.diligencetech.platform.iam.domain.model.valueobjects.Roles;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true, length = 20)
    private Roles name;

    public Role() {
    }

    public Role(Roles name) {
        this.name = name;
    }

    public String getStringName() {
        return name.name();
    }

    public static Role getDefaultRole() {
        return new Role(Roles.ROLE_USER);
    }

    public static Role toRoleFromName(String name) {
        return new Role(Roles.valueOf(name));
    }

    public static List<Role> validateRoleSet(List<Role> roles) {
        if (roles == null || roles.isEmpty()) {
            return List.of(getDefaultRole());
        }
        return roles;
    }
}

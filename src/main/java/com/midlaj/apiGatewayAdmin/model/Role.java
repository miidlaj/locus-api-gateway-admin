package com.midlaj.apiGatewayAdmin.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    @Column(length = 150, nullable = false)
    private String description;

    public Role(ERole name, String description) {
        this.name = name;
        this.description = description;
    }
}

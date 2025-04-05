package br.com.luscaer.api_scrum.entity;

import br.com.luscaer.api_scrum.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(length = 100, nullable = false)
    protected String name;

    @Column(length = 100, unique = true, nullable = false)
    protected String email;

    @Column(length = 15, nullable = false)
    protected String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    protected Gender gender;
}

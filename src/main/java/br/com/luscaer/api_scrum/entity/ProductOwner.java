package br.com.luscaer.api_scrum.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductOwner extends Person {
    @Column(length = 300)
    private String responsibilities;

    @OneToMany(mappedBy = "productOwner", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"productOwner"})
    private List<Project> projects;
}
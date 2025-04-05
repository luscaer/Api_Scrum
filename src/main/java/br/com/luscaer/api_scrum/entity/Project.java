package br.com.luscaer.api_scrum.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 1000)
    private String expectations;

    private LocalDate initialDate;

    private LocalDate finalDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_owner_id", nullable = false)
    @JsonIgnoreProperties({"projects"})
    private ProductOwner productOwner;

}

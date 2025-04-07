package br.com.luscaer.api_scrum.repository;

import br.com.luscaer.api_scrum.entity.ProductOwner;
import br.com.luscaer.api_scrum.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductOwnerRepository extends JpaRepository<ProductOwner, Long> {

    List<ProductOwner> findByNameContainingIgnoreCaseOrderByNameAsc(String name);

    List<ProductOwner> findByGenderOrderByNameAsc(Gender gender);

}
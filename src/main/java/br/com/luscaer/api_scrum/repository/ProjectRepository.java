package br.com.luscaer.api_scrum.repository;

import br.com.luscaer.api_scrum.entity.ProductOwner;
import br.com.luscaer.api_scrum.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByNameContainingIgnoreCaseOrderByNameAsc(String name);

    Project findByProductOwner(ProductOwner productOwner);

    List<Project> findByInitialDateGreaterThanEqualAndFinalDateLessThanEqual(LocalDate start, LocalDate end);
//    @Query("SELECT p FROM Project p WHERE p.initialDate >= :start AND p.finalDate <= :end")
//    List<Project> findProjectsWithinDateRange(@Param("start") LocalDate start, @Param("end") LocalDate end);

}

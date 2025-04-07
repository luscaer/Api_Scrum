package br.com.luscaer.api_scrum.service;


import br.com.luscaer.api_scrum.entity.ProductOwner;
import br.com.luscaer.api_scrum.entity.Project;
import br.com.luscaer.api_scrum.repository.ProjectRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceTest {

    //    Cria um mock de ProjectRepository (Não se conecta com banco de dados)
    @Mock
    private ProjectRepository projectRepository;

    //    Cria uma instância real do ProjectService e injeta mocks nele
    @InjectMocks
    private ProjectService projectService;

    //    Projetos usado nos testes
    private Project project;
    private Project secondProject;
    private Project thirdProject;
    private List<Project> projectList;


    @BeforeEach
    void setup() {
        ProductOwner productOwner = new ProductOwner();
        ProductOwner anotherProductOwner = new ProductOwner();
        productOwner.setId(1L);
        anotherProductOwner.setId(2L);

        project = new Project();
        project.setId(1L);
        project.setName("Test Project");
        project.setExpectations("Build something great");
        project.setInitialDate(LocalDate.of(2025, 1, 1));
        project.setFinalDate(LocalDate.of(2026, 1, 1));
        project.setProductOwner(productOwner);

        secondProject = new Project();
        secondProject.setId(2L);
        secondProject.setName("Second Test Project");
        secondProject.setExpectations("Make something else");
        secondProject.setInitialDate(LocalDate.of(2024, 6, 1));
        secondProject.setFinalDate(LocalDate.of(2024, 12, 1));
        secondProject.setProductOwner(productOwner);

        thirdProject = new Project();
        thirdProject.setId(2L);
        thirdProject.setName("Third Test Project");
        thirdProject.setExpectations("Do another thing");
        thirdProject.setInitialDate(LocalDate.of(2025, 6, 1));
        thirdProject.setFinalDate(LocalDate.of(2026, 12, 1));
        thirdProject.setProductOwner(anotherProductOwner);

        projectList = List.of(project, secondProject, thirdProject);
    }

    @Test
    void testSaveProject() {
        when(projectRepository.save(project)).thenReturn(project);

        String message = projectService.save(project);

        verify(projectRepository, times(1)).save(project);

        assertEquals("Project saved successfully!", message);
    }

    @Test
    void testUpdateProject() {
        when(projectRepository.existsById(1L)).thenReturn(true);
        when(projectRepository.save(project)).thenReturn(project);

        String message = projectService.update(project, 1L);

        verify(projectRepository, times(1)).existsById(1L);
        verify(projectRepository, times(1)).save(project);

        assertEquals("Project successfully updated!", message);
    }

    @Test
    void testUpdateProjectNotfound() {
        when(projectRepository.existsById(1L)).thenReturn(false);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            projectService.update(project, 1L);
        });

        verify(projectRepository, never()).save(any());

        assertEquals("Project not found", exception.getMessage());
    }

    @Test
    void testDeleteProject() {
        when(projectRepository.existsById(1L)).thenReturn(true);

        String message = projectService.delete(1L);

        verify(projectRepository, times(1)).deleteById(1L);

        assertEquals("Project deleted successfully!", message);
    }

    @Test
    void testDeleteProjectNotFound() {
        when(projectRepository.existsById(1L)).thenReturn(false);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            projectService.delete(1L);
        });

        verify(projectRepository, never()).deleteById(1L);

        assertEquals("Project not found", exception.getMessage());
    }

    @Test
    void findAllProjects() {
        when(projectRepository.findAll()).thenReturn(projectList);

        List<Project> projectList = projectService.findAll();

        verify(projectRepository, times(1)).findAll();

        assertEquals(3, projectList.size());
    }

    @Test
    void findById() {
        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));

        Project projectResult = projectService.findById(1L);

        verify(projectRepository, times(1)).findById(1L);

        assertEquals("Test Project", projectResult.getName());
    }

    @Test
    void findByIdNotFound() {
        when(projectRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            projectService.findById(1L);
        });

        verify(projectRepository, times(1)).findById(1L);

        assertEquals("Project not found", exception.getMessage());
    }

    @Test
    void findByName() {
        when(projectRepository.findByNameContainingIgnoreCaseOrderByNameAsc("test")).thenReturn(projectList);

        List<Project> projectList = projectService.findByName("test");

        verify(projectRepository, times(1)).findByNameContainingIgnoreCaseOrderByNameAsc("test");

        assertEquals(3, projectList.size());
    }

    @Test
    void findByProductOwner() {
        ProductOwner productOwner = new ProductOwner();
        productOwner.setId(1L);

        when(projectRepository.findByProductOwner(argThat(po -> po.getId().equals(1L)))).thenReturn(List.of(project, secondProject));

        List<Project> projectListResult = projectService.findByProductOwner(1L);

        verify(projectRepository, times(1)).findByProductOwner(argThat(po -> po.getId().equals(1L)));

        assertEquals(2, projectListResult.size());
        assertTrue(projectListResult.stream().allMatch(p -> p.getProductOwner().getId().equals(1L)));
    }

    @Test
    void findByDateRange() {
        LocalDate start = LocalDate.of(2024, 1, 1);
        LocalDate end = LocalDate.of(2026, 1, 1);

        when(projectRepository.findByInitialDateGreaterThanEqualAndFinalDateLessThanEqual(start, end)).thenReturn(projectList);

        List<Project> projectList = projectService.findProjectsByDateRange(start, end);

        verify(projectRepository, times(1)).findByInitialDateGreaterThanEqualAndFinalDateLessThanEqual(start, end);
        assertEquals(3, projectList.size());
    }
}

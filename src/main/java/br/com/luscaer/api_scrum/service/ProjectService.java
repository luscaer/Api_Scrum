package br.com.luscaer.api_scrum.service;

import br.com.luscaer.api_scrum.entity.Project;
import br.com.luscaer.api_scrum.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public String save(Project project) {
        this.projectRepository.save(project);
        return "Project saved successfully!";
    }

    public String update(Project project, Long id) {
        if (!projectRepository.existsById(id)) {
            throw new RuntimeException("Project not found");
        }
        project.setId(id);
        this.projectRepository.save(project);
        return "Project successfully updated!";
    }

    public String delete(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new RuntimeException("Project not found");
        }
        this.projectRepository.deleteById(id);
        return "Project deleted successfully!";
    }

    public List<Project> findAll() {
        return this.projectRepository.findAll();
    }

    public Project findById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductOwner not found"));
    }
}

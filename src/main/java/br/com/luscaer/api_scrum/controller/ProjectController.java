package br.com.luscaer.api_scrum.controller;

import br.com.luscaer.api_scrum.entity.Project;
import br.com.luscaer.api_scrum.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Project project) {
        try {
            String message = this.projectService.save(project);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Project project, @PathVariable Long id) {
        try {
            String message = this.projectService.update(project, id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            String message = this.projectService.delete(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Project>> findAll() {
        try {
            List<Project> projectList = this.projectService.findAll();
            return new ResponseEntity<>(projectList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Project> findById(@PathVariable Long id) {
        try {
            Project project = this.projectService.findById(id);
            return new ResponseEntity<>(project, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<Project>> findByName(@RequestParam String name) {
        try {
            List<Project> projectList = this.projectService.findByName(name);
            return new ResponseEntity<>(projectList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByProductOwner")
    public ResponseEntity<Project> findByProductOwner(@RequestParam Long id) {
        try {
            Project project = this.projectService.findByProductOwner(id);
            return new ResponseEntity<>(project, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/searchByDate")
    public ResponseEntity<List<Project>> findProjectsByDateRange(@RequestParam LocalDate start, @RequestParam LocalDate end) {
        try {
            List<Project> projectList = this.projectService.findProjectsByDateRange(start, end);
            return new ResponseEntity<>(projectList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

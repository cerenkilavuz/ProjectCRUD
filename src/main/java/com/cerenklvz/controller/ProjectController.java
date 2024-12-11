package com.cerenklvz.controller;

import com.cerenklvz.entity.Project;
import com.cerenklvz.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    
    @GetMapping("/list")
    public String listProject(Model model){
        try{
            List<Project> projects = projectService.getProjects();
            model.addAttribute("projects", projects);
        }catch (Exception e){
            model.addAttribute("projects", null);
        }
        return "project-list";
    }

    @GetMapping("/show-project-form")
    public String showProjectForm(Model model){
        model.addAttribute("project", new Project());
        return "project-form";
    }

    @GetMapping("/update-form")
    public String updateProjectForm(@RequestParam("id")int id,Model model){
        model.addAttribute("project", projectService.getProject(id));
        return "project-form";
    }

    @PostMapping("/save")
    public String saveProject(@ModelAttribute("project") Project project){
        projectService.saveOrUpdate(project);
        return "redirect:/project/list";
    }

    @GetMapping("/delete")
    public String deleteProject(@RequestParam("id") int id){
        projectService.delete(id);
        return "redirect:/project/list";
    }
}
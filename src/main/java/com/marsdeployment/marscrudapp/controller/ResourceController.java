package com.marsdeployment.marscrudapp.controller;

import com.marsdeployment.marscrudapp.model.Resource;
import com.marsdeployment.marscrudapp.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/resources")
public class ResourceController {
    
    /**
    * Resource repository.
    */
    @Autowired
    private ResourceRepository resourceRepository;

    /**
    * Shows all resources.
    * 
    * @param model
    * @return resources
    */
    @GetMapping
    public String showAllResources(Model model) {
        model.addAttribute("resources", resourceRepository.findAll());
        return "resources";
    }

    /**
    * Shows form to add a resource.
    * 
    * @param model 
    * @return view containing the form for adding a resource
    */
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("resource", new Resource());
        return "add-resource";
    }

    /**
    * Processes adding a resource.
    * 
    * @param resource
    * @return redirection after adding the resource.
    */
    @PostMapping("/add")
    public String addResource(@ModelAttribute Resource resource) {
        resourceRepository.save(resource);
        return "redirect:/resources";
    }

    /**
    * Shows edit form to edit a resource.
    * 
    * @param id
    * @param model
    * @return view of the edit form for editing the resource.
    */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Resource resource = resourceRepository.findById(id)
                            .orElseThrow(() -> new IllegalArgumentException("Invalid resource ID"));
        model.addAttribute("resource", resource);
        return "edit-resource";
    }

    /**
     * Processes editing a resource.
     * 
     * @param id
     * @param resource
     * @return redirection after editing the resource.
     */
    @PostMapping("/edit/{id}")
    public String editResource(@PathVariable Long id, @ModelAttribute Resource resource) {
            resource.setId(id);
            resourceRepository.save(resource);
            return "redirect:/resources";
    }

    /**
    * Deletes a resource.
    * 
    * @param id
    * @return redirection after deleting the resource.
    */
    @GetMapping("/delete/{id}")
    public String deleteResource(@PathVariable Long id) {
        resourceRepository.deleteById(id);
        return "redirect:/resources";
    }
}

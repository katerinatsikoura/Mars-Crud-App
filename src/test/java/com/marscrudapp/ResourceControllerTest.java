package com.marscrudapp;

import com.marscrudapp.model.Resource;
import com.marscrudapp.repository.ResourceRepository;
import com.marscrudapp.controller.ResourceController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ResourceControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ResourceRepository resourceRepository;

    @InjectMocks
    private ResourceController resourceController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(resourceController).build();
    }

    @Test
    void testShowAddForm() throws Exception {
        mockMvc.perform(get("/resources/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("add-resource"))
                .andExpect(model().attributeExists("resource"));
    }

    @Test
    void testAddResource() throws Exception {
        when(resourceRepository.save(any(Resource.class))).thenReturn(new Resource("Resource3", 3));

        mockMvc.perform(post("/resources/add")
                .param("name", "Resource3")
                .param("quantity", "3"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/resources"));
    }

    @Test
    void testShowEditForm() throws Exception {
        Resource resource = new Resource("Resource1", 1);
        resource.setId(1L);
        when(resourceRepository.findById(1L)).thenReturn(Optional.of(resource));

        mockMvc.perform(get("/resources/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("edit-resource"))
                .andExpect(model().attributeExists("resource"));
    }

    @Test
    void testEditResource() throws Exception {
        Resource resource = new Resource("Resource1", 1);
        resource.setId(1L);
        when(resourceRepository.save(any(Resource.class))).thenReturn(resource);

        mockMvc.perform(post("/resources/edit/1")
                .param("name", "UpdatedResource")
                .param("quantity", "2"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/resources"));
    }

    @Test
    void testDeleteResource() throws Exception {
        mockMvc.perform(get("/resources/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/resources"));

        Mockito.verify(resourceRepository).deleteById(1L);
    }
}

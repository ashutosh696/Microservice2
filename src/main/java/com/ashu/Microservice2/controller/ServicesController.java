package com.ashu.Microservice2.controller;


import com.ashu.Microservice2.model.Services;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
@RequestMapping("/services")
public class ServicesController {

    private static final List<Services> Services = List.of(
            new Services(1, "X-Ray", 500),
            new Services(2, "Scan", 600)
    );

    @GetMapping
    public List<Services> getAll() {
        return Services;
    }

    @GetMapping("/{id}")
    public Services getById(@PathVariable int id) {
        return Services.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }
}

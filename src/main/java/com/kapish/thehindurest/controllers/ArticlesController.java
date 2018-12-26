package com.kapish.thehindurest.controllers;

import com.kapish.thehindurest.models.Articles;
import com.kapish.thehindurest.repositories.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticlesController {
    @Autowired
    private ArticlesRepository repository;

    @RequestMapping(value = "/allarticles", method = RequestMethod.GET)
    public List<Articles> getAllArticles() {
        return repository.findAll();
    }
}

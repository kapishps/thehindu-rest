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
public class ArticlesController {
    @Autowired
    private ArticlesRepository repository;

    @RequestMapping(value = "/allarticles", method = RequestMethod.GET)
    public List<Articles> getAllArticles() {
        return repository.findAll();
    }

    @RequestMapping(value = "/getarticlesbyauthor/{author}", method = RequestMethod.GET)
    public List<Articles> getAllArticlesByAuthor(@PathVariable("author") String author) {
        return repository.findBy_author(author);
    }

    @RequestMapping(value = "/getarticlesbydate/{date}", method = RequestMethod.GET)
    public List<Articles> getAllArticlesByDate(@PathVariable("date") String date) {
        return repository.findBy_date(date);
    }

    @RequestMapping(value = "/getarticlesbycity/{city}", method = RequestMethod.GET)
    public List<Articles> getAllArticlesByCity(@PathVariable("city") String city) {
        return repository.findBy_city(city);
    }

    @RequestMapping(value = "/getarticlesbytags", method = RequestMethod.POST)
    public List<Articles> getAllArticlesByTags(@RequestBody List<String> tags) {
        return repository.findBy_tags(tags);
    }

    @RequestMapping(value = "/getarticlesbycategories", method = RequestMethod.POST)
    public List<Articles> getAllArticlesByCategories(@RequestBody List<String> categories) {
        return repository.findBy_categories(categories);
    }
}

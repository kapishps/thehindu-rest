package com.kapish.thehindurest.controllers;

import com.kapish.thehindurest.models.Authors;
import com.kapish.thehindurest.models.Articles;
import com.kapish.thehindurest.repositories.AuthorsRepository;
import com.kapish.thehindurest.repositories.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthorsController {
    @Autowired
    private AuthorsRepository repository;

    @Autowired
    private ArticlesRepository articlesRepository;

    @RequestMapping(value = "/getallauthors", method = RequestMethod.GET)
    public List<String> getAllAuthors() {
        List<Authors> authors = repository.findAll();
        List<String> ret = new ArrayList<String>();
        for(Authors i: authors){
            ret.add(i.getAuthor());
        }
        return ret;
    }

    @RequestMapping(value = "/getarticlesbyauthor/{author}", method = RequestMethod.GET)
    public List<Articles> getAllArticlesByAuthor(@PathVariable("author") String author) {
        List<Authors> authors = repository.findBy_author(author);
        List<Articles> ret = new ArrayList<Articles>();
        for(Authors i: authors){
            ret.addAll(articlesRepository.findBy_articleid(i.getArticleids()));
        }
        return ret;
    }
}

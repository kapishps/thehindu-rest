package com.kapish.thehindurest.controllers;

import com.kapish.thehindurest.models.Cities;
import com.kapish.thehindurest.models.Articles;
import com.kapish.thehindurest.repositories.CitiesRepository;
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
public class CitiesController {
    @Autowired
    private CitiesRepository repository;

    @Autowired
    private ArticlesRepository articlesRepository;

    @RequestMapping(value = "/getarticlesbycity/{city}", method = RequestMethod.GET)
    public List<Articles> getAllArticlesByCity(@PathVariable("city") String city) {
        List<Cities> cities = repository.findBy_city(city);
        List<Articles> ret = new ArrayList<Articles>();
        for(Cities i: cities){
            ret.addAll(articlesRepository.findBy_articleid(i.getArticleids()));
        }
        return ret;
    }
}

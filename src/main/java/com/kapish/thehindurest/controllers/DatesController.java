package com.kapish.thehindurest.controllers;

import com.kapish.thehindurest.models.Articles;
import com.kapish.thehindurest.models.Dates;
import com.kapish.thehindurest.repositories.ArticlesRepository;
import com.kapish.thehindurest.repositories.DatesRepository;
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
public class DatesController {
    @Autowired
    private DatesRepository repository;

    @Autowired
    private ArticlesRepository articlesRepository;

    @RequestMapping(value = "/getarticlesbydate/{date}", method = RequestMethod.GET)
    public List<Articles> getAllArticlesByDate(@PathVariable("date") String date) {
        List<Dates> dates = repository.findBy_date(date);
        List<Articles> ret = new ArrayList<Articles>();
        for(Dates i: dates){
            ret.addAll(articlesRepository.findBy_articleid(i.getArticleids()));
        }
        return ret;
    }

    @RequestMapping(value = "/getauthorsbydate/{date}", method = RequestMethod.GET)
    public List<String> getAllAuthorsByDate(@PathVariable("date") String date) {
        List<Dates> dates = repository.findBy_date(date);
        List<String> ret = new ArrayList<String>();
        for(Dates i: dates){
            List<Articles> articles = articlesRepository.findBy_articleid(i.getArticleids());
            for(Articles j : articles){
                ret.add(j.getAuthor());
            }
        }
        return ret;
    }
}

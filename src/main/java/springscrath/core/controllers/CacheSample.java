/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springscrath.core.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springscrath.core.model.entities.User;

/**
 *
 * @author adiel
 */
@RequestMapping("/micache")
@RestController
public class CacheSample {

    /*  The annotations that are managed by this post processor are Cacheable, CachePut and CacheEvict. You can refer to the javadocs and the documentation for more details. 
   
    For caching declaration, the abstraction provides a set of Java annotations:

    @Cacheable triggers cache population
    @CacheEvict triggers cache eviction
    @CachePut updates the cache without interfering with the method execution
    @Caching regroups multiple cache operations to be applied on a method
    @CacheConfig shares some common cache-related settings at class-level 
    
    
     */
    public static int contador = 0;

    @RequestMapping(value = "/ejemplosi", method = RequestMethod.GET)
    @JsonView(int.class)
    public int ejemplo1() {
        return ++contador;
    }

    @Cacheable("greetings")
    @RequestMapping(value = "/ejemplono", method = RequestMethod.GET)
    @JsonView(int.class)
    public int ejemplono() {
        return ++contador;
    }

    //   https://www.youtube.com/watch?v=g4h268Hx0AU&list=PLGDwUiT1wr6-Fn3N2oqJpTdhGjFHnIIKY&index=7
    @CacheEvict("greetings")
    @RequestMapping(value = "/limpiar", method = RequestMethod.GET)
    @JsonView(int.class)
    public int reiniciar() {
//        return ++contador;
        return 100;
    }

}

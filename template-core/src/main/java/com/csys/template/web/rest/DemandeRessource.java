/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.web.rest;

import com.csys.template.domain.Demande;
import com.csys.template.repository.DemandeRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 21694
 */

@RestController
@RequestMapping("/demande")
public class DemandeRessource {
    @Autowired
    DemandeRepository dr;
    @GetMapping("/findAll")
    public ArrayList<Demande> findAll(){
        return (ArrayList<Demande>) dr.findAll();
    }
    
}

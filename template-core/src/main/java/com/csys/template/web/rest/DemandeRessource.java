/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.web.rest;

import com.csys.template.dto.DemandeDTO;
import com.csys.template.service.DemandeService;
import java.util.ArrayList;
import com.csys.template.domain.EtatDemandeEnum;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 21694
 */

@RestController
@RequestMapping("/api")
public class DemandeRessource {
    @Autowired
    private DemandeService demandeService;
    
    @GetMapping("/{lazy}/{etat}/{codeDemande}")
    public ArrayList<DemandeDTO> findAllByEtat(@PathVariable boolean lazy,@PathVariable(required = false) EtatDemandeEnum etat,@PathVariable(required = false) String codeDemande){
        return  (ArrayList<DemandeDTO>) demandeService.findAllDTO(lazy,etat,codeDemande) ;
    }
    
    @GetMapping("/demandes")
    public ArrayList<DemandeDTO> findDemande(){
        return   (ArrayList<DemandeDTO>) demandeService.findAllDTO();
    }
    
    @PutMapping("/demande")
    public void addDemande(@Valid @RequestBody DemandeDTO demandeDTO){
        demandeService.saveDTO(demandeDTO);
    }
    
    @PostMapping("/updateDemande")
    public void updateDemande(@Valid @RequestBody DemandeDTO demandeDTO){
        demandeService.updateDTO(demandeDTO);
    }
    
    @DeleteMapping("/delete/{codeDemande}")
    public void delete(@PathVariable String codeDemande){
        demandeService.delete(codeDemande);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.web.rest;

import com.csys.template.dto.ModuleDTO;
import com.csys.template.service.ModuleService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 21694
 */
@RestController
@RequestMapping("/api")
public class ModuleRessource {
    @Autowired
    private ModuleService moduleService;
    
    @GetMapping("/modules")   
    public ArrayList<ModuleDTO> findAll(){
        return  (ArrayList<ModuleDTO>) moduleService.findAllDTO();
    }
    
    @GetMapping("module/{numModule}")
    public ModuleDTO findByNumModule(@PathVariable String numModule){
        return moduleService.findModuleDTO(numModule);
    }
    
    @GetMapping("/moduleActif")
    public ArrayList<ModuleDTO> findAllActif(@RequestParam boolean afficher){
        return moduleService.findAllDTOAfficher(afficher);
    }
    
    
}

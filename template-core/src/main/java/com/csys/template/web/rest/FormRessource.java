/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.web.rest;

import com.csys.template.dto.FormDTO;
import com.csys.template.service.FormService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 21694
 */
@RestController
@RequestMapping("/api")
public class FormRessource {
    @Autowired
    private FormService formService;
    
    @GetMapping("/findAllForm")   
    public ArrayList<FormDTO> findAll(){
        return  (ArrayList<FormDTO>) formService.findAllDTO();
    }
    
    @GetMapping("/findByFormPK")
    public FormDTO findByFormPK(@RequestParam String module,@RequestParam String form,@RequestParam String control,@RequestParam String codeMenu){
        
        return formService.findFormDTO(module, form, control, codeMenu);
    }
}

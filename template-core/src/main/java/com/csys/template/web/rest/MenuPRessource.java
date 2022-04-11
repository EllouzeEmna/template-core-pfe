/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.web.rest;

import com.csys.template.dto.MenuPDTO;
import com.csys.template.service.MenuPService;
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
public class MenuPRessource {
    @Autowired
    private MenuPService menuPService;
    
    @GetMapping("/findAllMenu")  
    public ArrayList<MenuPDTO> findAll(){
        return  (ArrayList<MenuPDTO>) menuPService.findAllDTO();
    }
    
    @GetMapping("/findByMenuPK")
    public MenuPDTO findByMenuPPK(@RequestParam String module,@RequestParam String codMnp){
        return menuPService.findMenuPDTO(module, codMnp);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.web.rest;

import com.csys.template.dto.MenuPDTO;
import com.csys.template.service.MenuPService;
import java.util.ArrayList;
import java.util.List;
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
    
    @GetMapping("/menus")  
    public ArrayList<MenuPDTO> findAll(){
        return  (ArrayList<MenuPDTO>) menuPService.findAllDTO();
    }
    
    @GetMapping("/menu")
    public List<MenuPDTO> findByMenuPPK(@RequestParam (required = false) String module,@RequestParam (required = false) String codMnp){
        return menuPService.findMenuPByModuleDTO(module, codMnp);
    }
    
}

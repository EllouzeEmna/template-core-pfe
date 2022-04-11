/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.web.rest;

import com.csys.template.dto.GroupUserDTO;
import com.csys.template.service.GroupUserService;
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
public class GroupUserRessource {
    @Autowired
    private GroupUserService groupUserService;
    
    @GetMapping("/findAllGroupUser")   
    public ArrayList<GroupUserDTO> findAll(){
        return  (ArrayList<GroupUserDTO>) groupUserService.findAllDTO();
    }
    
    @GetMapping("/findByGrp/{grp}")
    public GroupUserDTO findByGrp(@PathVariable String grp){
        return groupUserService.findGroupUserDTO(grp);
    }
    
    @GetMapping("/findAllGroupUserActif")
    public ArrayList<GroupUserDTO> findAllDTO(@RequestParam(required = false) Boolean[] actifs, @RequestParam(required = false) String grp, @RequestParam(required = false) String description){
        return groupUserService.findAllDTO(actifs, grp, description);
    }
}

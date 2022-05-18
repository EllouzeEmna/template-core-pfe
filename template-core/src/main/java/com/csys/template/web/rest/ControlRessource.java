/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.web.rest;

import com.csys.template.dto.AccessControlDTO;
import com.csys.template.dto.GroupUserDTO;
import com.csys.template.service.AccessControlService;
import java.util.ArrayList;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 21694
 */
@RestController
@RequestMapping("/api")
public class ControlRessource {

    @Autowired
    private AccessControlService controlService;

    @GetMapping("/accessControl")
    public ArrayList<AccessControlDTO> findAll(@RequestParam(required = false) Boolean[] actifs, @RequestParam(required = false) Boolean[] personalises, @RequestParam(required = false) String group,@RequestParam(required = false) String[] userNames) {
        return (ArrayList<AccessControlDTO>) controlService.findAllDTO(actifs, personalises, group,userNames);
    }

    @GetMapping("/accessControl/{userName}")
    public AccessControlDTO findByUserName(@PathVariable String userName) {
        return controlService.findAccessControlDTO(userName);
    }
    @PutMapping("/accessControl/{userName}")
    public AccessControlDTO updateGroup(@PathVariable String userName, @Valid @RequestBody AccessControlDTO accessControlDTO) {
        accessControlDTO.setUserName(userName);
        AccessControlDTO result = controlService.update(accessControlDTO);
        return result;
    }
    
    @PostMapping("/accessControl")
    public AccessControlDTO createAccessControl(@Valid @RequestBody AccessControlDTO accessControlDTO)  {
        AccessControlDTO result= controlService.save(accessControlDTO);
        return result;
    }
    
    @DeleteMapping("/accessControl")
    public void deleteAccessControl(@RequestParam(required = false) String userName) {
        controlService.delete(userName);
    }
}

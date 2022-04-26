/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.web.rest;

import com.csys.template.dto.AccessControlDTO;
import com.csys.template.service.ControlService;
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
public class ControlRessource {

    @Autowired
    private ControlService controlService;

    @GetMapping("/accessControls")
    public ArrayList<AccessControlDTO> findAll(@RequestParam(required = false) Boolean[] actifs, @RequestParam(required = false) Boolean[] personalises, @RequestParam(required = false) String group) {
        return (ArrayList<AccessControlDTO>) controlService.findAllDTO(actifs, personalises, group);
    }

    @GetMapping("accessControl/{userName}")
    public AccessControlDTO findByUserName(@PathVariable String userName) {
        return controlService.findAccessControlDTO(userName);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.web.rest;

import com.csys.template.dto.GroupUserDTO;
import com.csys.template.service.GroupUserService;
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
public class GroupUserRessource {

    @Autowired
    private GroupUserService groupUserService;

    @GetMapping("/group-users/{grp}")
    public GroupUserDTO findByGrp(@PathVariable String grp) {
        return groupUserService.findGroupUserDTO(grp);
    }

    @GetMapping("/group-users")
    public ArrayList<GroupUserDTO> findAllDTO(@RequestParam(required = false) Boolean[] actifs, @RequestParam(required = false) String grp, 
            @RequestParam(required = false) String description,@RequestParam(required = false,defaultValue = "true") boolean lazy,
            @RequestParam(required = false) String[] groupUsers) {
        return (ArrayList<GroupUserDTO>) groupUserService.findAllDTO(actifs, grp, description,  lazy,groupUsers);
    }
//
//    @PostMapping("/group-users")
//    public GroupUserDTO createGroup(@Valid @RequestBody GroupUserDTO groupUserDTO) {
//        GroupUserDTO result = groupUserService.save(groupUserDTO);
//        return result;
//    }
//
//    @PutMapping("/group-users/{grp}")
//    public GroupUserDTO updateGroup(@PathVariable String grp, @Valid @RequestBody GroupUserDTO groupUserDTO) {
//        groupUserDTO.setGrp(grp);
//        GroupUserDTO result = groupUserService.update(groupUserDTO);
//        return result;
//    }
    @DeleteMapping("/group-users/{grp}")
    public void deleteGroup(@PathVariable String grp) {
        groupUserService.delete(grp);
    }
}

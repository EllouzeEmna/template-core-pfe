/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.web.rest;

import com.csys.template.dto.DemandeFormDTO;
import com.csys.template.factory.DemandeMenuFactory;
import com.csys.template.factory.DemandeModuleFactory;
import com.csys.template.service.DemandeFormService;
import com.csys.template.service.DemandeMenuService;
import com.csys.template.service.DemandeModuleService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
 * REST controller for managing Demande.
 */

@RestController
@RequestMapping("/api")
public class DemandeFormRessource {
    
    private static final String ENTITY_NAME = "demandeForm";

    private final DemandeFormService dFormService;
    private DemandeModuleService dModuleService;
    private DemandeMenuService dMenuService;
    private DemandeModuleFactory dModuleFactory;
    private DemandeMenuFactory dMenuFactory;
    private final Logger log = LoggerFactory.getLogger(DemandeFormService.class);

    public DemandeFormRessource(DemandeFormService dFormService) {
     this.dFormService=dFormService;
    }
    
    @PutMapping("/demandeForm")
    public ResponseEntity<DemandeFormDTO> createDemandeForm(@Valid @RequestBody DemandeFormDTO dfDTO,BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
     log.debug("REST request to save DemandeForm : {}", dfDTO);
//      if ( dfDTO.getDemandeFormPK() != null) {
//      bindingResult.addError( new FieldError("DemandeFormDTO","demandeFormPK","POST method does not accepte "+ENTITY_NAME+" with code"));
//      throw new MethodArgumentNotValidException(null, bindingResult);
//    }
    if (bindingResult.hasErrors()) {
      throw new MethodArgumentNotValidException(null, bindingResult);
    }
     DemandeFormDTO resultForm = dFormService.save(dfDTO); 
//     
     return ResponseEntity.created( new URI("/api/demandeForm/"+ resultForm.getCodeDemande())).body(resultForm);   
    }
    
    @PostMapping("/demandes/{codeForm}/{codeModule}/{coddeMenu}")
    public ResponseEntity<DemandeFormDTO> updateDemandeForm(@PathVariable String codeForm,@PathVariable String codeModule,@PathVariable String codeMenu,
            @Valid @RequestBody DemandeFormDTO demandeFormDTO) throws MethodArgumentNotValidException {
     log.debug("Request to update DemandeForm: {}",codeForm);
//     DemandeFormPK demandeFormPK=new DemandeFormPK(codeForm,codeModule,codeMenu,demandeFormDTO.getCodeDemande().getCodeDemande());
//     demandeFormDTO.setDemandeFormPK(demandeFormPK);
//     demandeFormDTO.setModule(demandeFormDTO.getModule());
     DemandeFormDTO result =dFormService.save(demandeFormDTO);
//     
//     DemandeModule dModule=new DemandeModule(result.getModule().getNumModule(),result.getDemandeFormPK().getCodeDemande());
//     DemandeModuleDTO dModuleDTO=dModuleFactory.demandeModuleToDemandeModuleDTO(dModule);
//     DemandeModuleDTO resultModule=dModuleService.save(dModuleDTO);
//     
//     DemandeMenu dMenu=new DemandeMenu(result.getDemandeFormPK().getCodeMenu(),result.getDemandeFormPK().getCodeDemande(),result.getModule().getNumModule());
//     DemandeMenuDTO dMenuDTO=dMenuFactory.demandeMenuToDemandeMenuDTO(dMenu);
//     DemandeMenuDTO resultMenu=dMenuService.save(dMenuDTO);
     
     return ResponseEntity.ok().body(result);
    }
    
    @GetMapping("/demandeForms")
    public List<DemandeFormDTO> getAllDemandeForms() {
        
     log.debug("Request to get all  DemandeForms : {}");
     return dFormService.findAllDTO();
    }
    
    @DeleteMapping("/demandes/{codeDemande}")
    public ResponseEntity<Void> deleteClasse(@PathVariable String codeDemande) {
        
     log.debug("Request to delete Classe: {}",codeDemande);
     dFormService.delete(codeDemande);
     return ResponseEntity.ok().build();
    }
}

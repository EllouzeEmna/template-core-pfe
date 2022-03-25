/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.service;

import com.csys.template.domain.Demande;
import com.csys.template.domain.DemandeForm;
import com.csys.template.domain.DemandeMenu;
import com.csys.template.domain.DemandeModule;
import com.csys.template.dto.DemandeDTO;
import com.csys.template.dto.DemandeFormDTO;
import com.csys.template.dto.DemandeMenuDTO;
import com.csys.template.dto.DemandeModuleDTO;
import com.csys.template.factory.DemandeFactory;
import com.csys.template.factory.DemandeFormFactory;
import com.csys.template.factory.DemandeMenuFactory;
import com.csys.template.factory.DemandeModuleFactory;
import com.csys.template.repository.DemandeFormRepository;
import com.csys.template.repository.DemandeMenuRepository;
import com.csys.template.repository.DemandeModuleRepository;
import com.csys.template.repository.DemandeRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 21694
 */
@Service
@Transactional
public class DemandeService {

    private final Logger log = LoggerFactory.getLogger(DemandeService.class);

    private final DemandeRepository dRepository;
    private DemandeFormRepository dFormRepository;
    private DemandeMenuRepository dMenuRepository;
    private DemandeModuleRepository dModulRepository;

    public DemandeService(DemandeRepository demandeRepository) {
        this.dRepository = demandeRepository;
    }

    @Transactional(
            readOnly = true
    )
    public List<DemandeDTO> findAllDTO(boolean lazy) {
        log.debug("Request to get All Demandes");
        List<Demande> result = dRepository.findAll();

        return DemandeFactory.demandeToDemandeDTOs(result, lazy);
    }

    @Transactional(
            readOnly = true
    )
    public List<Demande> findAll() {
        log.debug("Request to get All Demandes");
        List<Demande> result = dRepository.findAll();
        return (result);
    }

    @Transactional(
            readOnly = true
    )
    public Demande findDemande(String codeDemande) {
        log.debug("Request to get Demande: {}", codeDemande);
        Demande d = dRepository.findByCodeDemande(codeDemande);
        return d;
    }

    @Transactional(
            readOnly = true
    )
    public DemandeDTO findDemandeDTO(String codeDemande) {
        log.debug("Request to get DemandeDTO: {}", codeDemande);
        Demande d = dRepository.findByCodeDemande(codeDemande);
        DemandeDTO dto = DemandeFactory.demandeToDemandeDTO(d, false);
        return dto;
    }

    public DemandeDTO saveDTO(DemandeDTO demandeDTO, DemandeFormDTO demandeFormDTO, DemandeMenuDTO demandeMenuDTO, DemandeModuleDTO demandeModuleDTO) {
        log.debug("Request to save Demande: {}", demandeDTO);
        Demande d = DemandeFactory.demandeDTOToDemande(demandeDTO);
        d = dRepository.save(d);
        DemandeDTO resultDTO = DemandeFactory.demandeToDemandeDTO(d, true);
        return resultDTO;
    }

    public void delete(String codeDemande) {
        log.debug("Request to delete Demande: {}", codeDemande);
        dRepository.deleteByDemandePK_CodeDemande(codeDemande);
    }
}

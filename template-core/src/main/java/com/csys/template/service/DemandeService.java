/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.service;

import com.csys.template.domain.Demande;
import com.csys.template.domain.EtatDemandeEnum;
import com.csys.template.dto.DemandeDTO;
import com.csys.template.factory.DemandeFactory;
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

    private final DemandeRepository demandeRepository;

    public DemandeService(DemandeRepository demandeRepository) {
        this.demandeRepository = demandeRepository;
    }

    @Transactional(
            readOnly = true
    )
    public List<DemandeDTO> findAllDTOByEtat(boolean lazy,EtatDemandeEnum etat) {
        log.debug("Request to get All Demandes");
        List<Demande> result = demandeRepository.findByEtat(etat);
        
        return DemandeFactory.demandeToDemandeDTOs(result, lazy);
    }
    
    @Transactional(
            readOnly = true
    )
    public List<DemandeDTO> findAllDTO(boolean lazy) {
        log.debug("Request to get All Demandes");
        List<Demande> result = demandeRepository.findAll();
        
        return DemandeFactory.demandeToDemandeDTOs(result, lazy);
    }

    @Transactional(
            readOnly = true
    )
    public List<Demande> findAllByEtat(EtatDemandeEnum etat) {
        log.debug("Request to get All Demandes");
        List<Demande> result = demandeRepository.findByEtat(etat);
        return (result);
    }

    @Transactional(
            readOnly = true
    )
    public Demande findDemande(String codeDemande) {
        log.debug("Request to get Demande: {}", codeDemande);
        Demande d = demandeRepository.findByCodeDemande(codeDemande);
        return d;
    }

    @Transactional(
            readOnly = true
    )
    public DemandeDTO findDemandeDTO(String codeDemande) {
        log.debug("Request to get DemandeDTO: {}", codeDemande);
        Demande d = demandeRepository.findByCodeDemande(codeDemande);
        DemandeDTO dto = DemandeFactory.demandeToDemandeDTO(d, false);
        return dto;
    }

    public DemandeDTO saveDTO(DemandeDTO demandeDTO) {
        log.debug("Request to save Demande: {}", demandeDTO);
        Demande d = DemandeFactory.demandeDTOToDemande(demandeDTO);
        d = demandeRepository.save(d);
        DemandeDTO resultDTO = DemandeFactory.demandeToDemandeDTO(d, true);
        return resultDTO;
    }
    
    public DemandeDTO updateDTO(DemandeDTO demandeDTO) {
        log.debug("Request to update Demande: {}", demandeDTO);
        Demande d = DemandeFactory.demandeDTOToDemande(demandeDTO);
        if(demandeRepository.findByCodeDemande(d.getCodeDemande())!=null){
        d = demandeRepository.save(d);
        }
        DemandeDTO resultDTO = DemandeFactory.demandeToDemandeDTO(d, true);
        return resultDTO;
    }

    public void delete(String codeDemande) {
        log.debug("Request to delete Demande: {}", codeDemande);
        if (findDemande(codeDemande).getEtat()==EtatDemandeEnum.NonValide)
        {demandeRepository.deleteByCodeDemande(codeDemande);}
    }
}

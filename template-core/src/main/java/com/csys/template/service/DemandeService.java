/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.service;

import com.csys.template.domain.AccessControl;
import com.csys.template.domain.AccessFormUser;
import com.csys.template.domain.AccessFormUserPK;
import com.csys.template.domain.AccessMenuUser;
import com.csys.template.domain.Demande;
import com.csys.template.domain.EtatDemandeEnum;
import com.csys.template.domain.Module;
import com.csys.template.domain.QDemande;
import com.csys.template.dto.DemandeDTO;
import com.csys.template.factory.AccessControlFactory;
import com.csys.template.factory.DemandeFactory;
import com.csys.template.repository.DemandeRepository;
import com.csys.template.util.Preconditions;
import com.csys.template.util.WhereClauseBuilder;
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
    public List<DemandeDTO> findAllDTO(boolean lazy,EtatDemandeEnum etat,String codeDemande) {
        log.debug("Request to get All Demandes");
        QDemande qDemande = QDemande.demande;
        WhereClauseBuilder builder;
        builder = new WhereClauseBuilder()
                .optionalAnd(etat, () -> qDemande.etat.eq(etat))
                .optionalAnd(codeDemande, () -> qDemande.codeDemande.eq(codeDemande));
        List<Demande> result = (List<Demande>) demandeRepository.findAll(builder);

        return DemandeFactory.demandeToDemandeDTOs(result, lazy);
    }
    public List<DemandeDTO> findAllDTO() {
        List<Demande> result = (List<Demande>) demandeRepository.findAll();
    
        return DemandeFactory.demandeToDemandeDTOs(result,true);
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
        Demande demande = DemandeFactory.demandeDTOToDemande(demandeDTO);
        AccessControl userDemande= AccessControlFactory.accessControlDTOToAccessControl(demandeDTO.getAccessControl());
        List<Module> listModule=(List<Module>) userDemande.getModuleCollection();
        List<AccessFormUser> listForm= (List<AccessFormUser>) userDemande.getAccessFormUserCollection();
        List<AccessMenuUser> listMenu=(List<AccessMenuUser>) userDemande.getAccessMenuUserCollection();
        
        demandeDTO.getDemandeFormCollection().forEach(x -> {
            listForm.forEach(y->{
                Preconditions.checkBusinessLogique(y.getForm().equals(x.getForm()), "acces Form exist deja.");
            });
        });
        demandeDTO.getDemandeMenuCollection().forEach(x -> {
            listMenu.forEach(y->{
                Preconditions.checkBusinessLogique(y.getMenuP().equals(x.getMenuP()), "acces Menu exist deja.");
            });        });
        demandeDTO.getDemandeModuleCollection().forEach(x -> {
        Preconditions.checkBusinessLogique(listModule.contains(x.getModule()), "acces module exist deja.");
        });
        
        Preconditions.checkBusinessLogique(demandeRepository.findByCodeDemande(demande.getCodeDemande())!=null, "L'utilasateur est inexistant.");

        demande = demandeRepository.save(demande);
        DemandeDTO resultDTO = DemandeFactory.demandeToDemandeDTO(demande, true);
        return resultDTO;
    }//groupe
    
    public void AcceptationPartielle(DemandeDTO demandeDTO, boolean cocher){
        log.debug("Request to accepter Demande: {}", demandeDTO);
        Demande demande = DemandeFactory.demandeDTOToDemande(demandeDTO);
        AccessControl userDemande= AccessControlFactory.accessControlDTOToAccessControl(demandeDTO.getAccessControl());
        List<Module> listModule=(List<Module>) userDemande.getModuleCollection();
        List<AccessFormUser> listForm= (List<AccessFormUser>) userDemande.getAccessFormUserCollection();
        List<AccessMenuUser> listMenu=(List<AccessMenuUser>) userDemande.getAccessMenuUserCollection();
        
        demandeDTO.getDemandeFormCollection().forEach(x -> {
            listForm.forEach(y->{
                Preconditions.checkBusinessLogique(y.getForm().equals(x.getForm()), "acces Form exist deja.");
            });
        });
        demandeDTO.getDemandeMenuCollection().forEach(x -> {
            listMenu.forEach(y->{
                Preconditions.checkBusinessLogique(y.getMenuP().equals(x.getMenuP()), "acces Menu exist deja.");
            });        });
        demandeDTO.getDemandeModuleCollection().forEach(x -> {
        Preconditions.checkBusinessLogique(listModule.contains(x.getModule()), "acces module exist deja.");
        });
            
        if (cocher==true){
           demandeDTO.getDemandeFormCollection().forEach(x -> {
          x.setValider(true);
          AccessFormUser accessFormUser=new AccessFormUser();
          AccessFormUserPK accessFormUserPK=new AccessFormUserPK();
          accessFormUserPK.setForm(x.getCodeForm());
          accessFormUser.setAccessFormUserPK(accessFormUserPK);
          listForm.add(accessFormUser);
        });
        }    
    }

    public void refuserDemande(DemandeDTO demandeDTO){
        demandeDTO.setEtat(EtatDemandeEnum.NonValide);
        demandeDTO.setMessage("demande refuser");
    }
    
    public void delete(String codeDemande) {
        log.debug("Request to delete Demande: {}", codeDemande);
        if (demandeRepository.findByCodeDemande(codeDemande).getEtat()==EtatDemandeEnum.NonValide)
        {demandeRepository.deleteByCodeDemande(codeDemande);}
    }
}

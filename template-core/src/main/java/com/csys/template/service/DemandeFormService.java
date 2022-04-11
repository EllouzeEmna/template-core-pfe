package com.csys.template.service;
import com.csys.template.domain.DemandeForm;
import com.csys.template.domain.DemandeFormPK;
import com.csys.template.dto.DemandeFormDTO;
import com.csys.template.factory.DemandeFormFactory;
import com.csys.template.repository.DemandeFormRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 * Service Implementation for managing Demande.
 */
@Service
@Transactional
public class DemandeFormService {
//    
//    private final Logger log = LoggerFactory.getLogger(DemandeFormService.class);
//
//    private final DemandeFormRepository dfRepository;
//
//    public DemandeFormService(DemandeFormRepository demandeFormRepository) {
//       this.dfRepository=demandeFormRepository;
//    }
//    
//    /**
//   * Save a demandeFormDTO.
//   *
//   * @param demandeFormDTO
//   * @return the persisted entity
//   */
//    public DemandeFormDTO save(DemandeFormDTO demandeFormDTO) {
//     log.debug("Request to save DemandeForm: {}",demandeFormDTO);
//     DemandeForm df = DemandeFormFactory.demandeFormDTOToDemandeForm(demandeFormDTO);
//     df = dfRepository.save(df);
//     DemandeFormDTO resultDTO = DemandeFormFactory.demandeFormToDemandeFormDTO(df);
//     return resultDTO;
//    }
//    
//   /**
//   * Get one demandeFormDTO by id.
//   *
//   * @param dfpk the demandeFormpk of the entity
//   * @return the entity DTO
//   */
//    @Transactional(
//      readOnly = true
//    )
//    public DemandeFormDTO findDemandeFormDTO(DemandeFormPK dfpk) {
//        
//     log.debug("Request to get DemandeFormDTO: {}",dfpk);
//     DemandeForm df= dfRepository.findByDemandeFormPK(dfpk);
//     DemandeFormDTO dto = DemandeFormFactory.demandeFormToDemandeFormDTO(df);
//     return dto;
//    }
//    
//    /**
//    * Get one demandeFormDTO by id.
//    *
//    * @param dfpk the demandeFormpk of the entity
//    * @return the entity DTO
//    */
//    @Transactional(
//      readOnly = true
//    )
//    public DemandeForm findDemandeForm(DemandeFormPK dfpk) {
//        
//     log.debug("Request to get DemandeForm: {}",dfpk);
//     DemandeForm df= dfRepository.findByDemandeFormPK(dfpk);
//     return df;
//    }
//    
//    /**
//   * Get all the demandeForms.
//   *
//   * @return the the list of entities
//   */
//    @Transactional(
//      readOnly = true
//    )
//    public List<DemandeFormDTO> findAllDTO() {
//     log.debug("Request to get All DemandeForms");
//     List<DemandeForm> result= dfRepository.findAll();
//     
//     return DemandeFormFactory.demandeFormToDemandeFormDTOs(result);
//    }
//    
//    @Transactional(
//      readOnly = true
//    )
//    public List<DemandeForm> findAll() {
//     log.debug("Request to get All DemandeForms");
//     List<DemandeForm> result= dfRepository.findAll();
//     return (result);
//    }
//    
//    /**
//    * Delete classe by codeDemande.
//    * @param codeDemande the id of the entity
//    */
//    public void delete(String codeDemande) {
//     log.debug("Request to delete DemandeForm: {}",codeDemande);
//     dfRepository.deleteByDemandeFormPK_CodeDemande(codeDemande);
//    }
}

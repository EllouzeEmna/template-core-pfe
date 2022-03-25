package com.csys.template.factory;

import com.csys.template.domain.DemandeForm;
import com.csys.template.domain.DemandeFormPK;
import com.csys.template.dto.DemandeFormDTO;
import java.util.ArrayList;
import java.util.List;

public class DemandeFormFactory {

    public static DemandeForm demandeFormDTOToDemandeForm(DemandeFormDTO demandeFormDTO) {
        DemandeForm demandeForm = new DemandeForm();
        DemandeFormPK demandeFormPK = new DemandeFormPK();
        demandeFormPK.setCodeDemande(demandeFormDTO.getCodeDemande());
        demandeFormPK.setCodeForm(demandeFormDTO.getCodeForm());
        demandeFormPK.setCodeMenu(demandeFormDTO.getCodeMenu());
        demandeFormPK.setCodeModule(demandeFormDTO.getCodeModule());
        demandeFormPK.setCodeControl(demandeFormDTO.getCodeControl());
        demandeForm.setDemandeFormPK(demandeFormPK);
        demandeForm.setValider(demandeFormDTO.getValider());
        return demandeForm;
    }

    public static DemandeFormDTO demandeFormToDemandeFormDTO(DemandeForm demandeForm,boolean lazy) {
        DemandeFormDTO demandeFormDTO = new DemandeFormDTO();
        demandeFormDTO.setCodeDemande(demandeForm.getDemandeFormPK().getCodeDemande());
        demandeFormDTO.setCodeForm(demandeForm.getDemandeFormPK().getCodeForm());
        demandeFormDTO.setCodeMenu(demandeForm.getDemandeFormPK().getCodeMenu());
        demandeFormDTO.setCodeModule(demandeForm.getDemandeFormPK().getCodeModule());
        demandeFormDTO.setForm(FormFactory.formToFormDTO(demandeForm.getForm(),lazy));
        demandeFormDTO.setValider(demandeForm.getValider());
        return demandeFormDTO;
    }

    public static List<DemandeFormDTO> demandeFormToDemandeFormDTOs(List<DemandeForm> demandeForms,boolean lazy) {
        List<DemandeFormDTO> demandeFormDTOs = new ArrayList<>();
        demandeForms.forEach(x -> {
            demandeFormDTOs.add(demandeFormToDemandeFormDTO(x,lazy));
        });
        return demandeFormDTOs;
    }

    public static List<DemandeForm> demandeFormDTOToDemandeForms(List<DemandeFormDTO> demandeFormDTOs) {
        List<DemandeForm> demandeForms = new ArrayList<>();
        demandeFormDTOs.forEach(x -> {
            demandeForms.add(demandeFormDTOToDemandeForm(x));
        });
        return demandeForms;
    }
}

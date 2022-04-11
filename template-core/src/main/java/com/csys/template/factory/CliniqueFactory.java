/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.factory;

import com.csys.template.domain.Clinique;
import com.csys.template.dto.CliniqueDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 21694
 */
public class CliniqueFactory {

    public static Clinique cliniqueDTOToClinique(CliniqueDTO cliniqueDTO) {
        Clinique clinique = new Clinique();
        clinique.setAccessControlList(AccessControlFactory.accessControlDTOToAccessControls(cliniqueDTO.getAccessControlList()));
        clinique.setAdresseClinique(cliniqueDTO.getAdresseClinique());
        clinique.setCodeClinique(cliniqueDTO.getCodeClinique());
        clinique.setNomClinique(cliniqueDTO.getNomClinique());
        return clinique;
    }

    public static CliniqueDTO cliniqueToCliniqueDTO(Clinique clinique) {
        CliniqueDTO cliniqueDTO = new CliniqueDTO();
        cliniqueDTO.setAccessControlList(AccessControlFactory.accessControlToAccessControlDTOs(clinique.getAccessControlList(), true));
        cliniqueDTO.setAdresseClinique(clinique.getAdresseClinique());
        cliniqueDTO.setCodeClinique(clinique.getCodeClinique());
        cliniqueDTO.setNomClinique(clinique.getNomClinique());
        return cliniqueDTO;
    }

    public static List<CliniqueDTO> cliniqueToCliniqueDTOs(List<Clinique> cliniques) {
        List<CliniqueDTO> cliniquesDTO = new ArrayList<>();
        cliniques.forEach(x -> {
            cliniquesDTO.add(cliniqueToCliniqueDTO(x));
        });
        return cliniquesDTO;
    }

    public static List<Clinique> cliniqueDTOToCliniques(List<CliniqueDTO> cliniqueDTOs) {
        List<Clinique> cliniques = new ArrayList<>();
        cliniqueDTOs.forEach(x -> {
            cliniques.add(cliniqueDTOToClinique(x));
        });
        return cliniques;
    }
}

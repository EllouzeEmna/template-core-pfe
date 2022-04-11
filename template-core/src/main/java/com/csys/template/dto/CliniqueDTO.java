/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.dto;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 21694
 */
public class CliniqueDTO {
    
    @NotNull
    @Size(min = 1, max = 50)
    private String codeClinique;
    @Size(max = 255)
    private String adresseClinique;
    @Size(max = 50)
    private String nomClinique;
    private List<AccessControlDTO> accessControlList;

    public String getCodeClinique() {
        return codeClinique;
    }

    public void setCodeClinique(String codeClinique) {
        this.codeClinique = codeClinique;
    }

    public String getAdresseClinique() {
        return adresseClinique;
    }

    public void setAdresseClinique(String adresseClinique) {
        this.adresseClinique = adresseClinique;
    }

    public String getNomClinique() {
        return nomClinique;
    }

    public void setNomClinique(String nomClinique) {
        this.nomClinique = nomClinique;
    }

    public List<AccessControlDTO> getAccessControlList() {
        return accessControlList;
    }

    public void setAccessControlList(List<AccessControlDTO> accessControlList) {
        this.accessControlList = accessControlList;
    }
    
    
}

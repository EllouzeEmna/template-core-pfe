/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 21694
 */
public class DemandeModuleDTO {

    @Size(min = 1, max = 3)
    private String numModule;
    
    @Size(min = 1, max = 20)
    private String codeDemande;
    @Size(max = 50)
    private Boolean valider;
    
    private Boolean validerNew; 
    
    private ModuleDTO module;

    public String getNumModule() {
        return numModule;
    }

    public void setNumModule(String numModule) {
        this.numModule = numModule;
    }

    public String getCodeDemande() {
        return codeDemande;
    }

    public void setCodeDemande(String codeDemande) {
        this.codeDemande = codeDemande;
    }

    public Boolean getValider() {
        return valider;
    }

    public void setValider(Boolean valider) {
        this.valider = valider;
    }

    public Boolean getValiderNew() {
        return validerNew;
    }

    public void setValiderNew(Boolean validerNew) {
        this.validerNew = validerNew;
    }

    public ModuleDTO getModule() {
        return module;
    }

    public void setModule(ModuleDTO module) {
        this.module = module;
    }

}

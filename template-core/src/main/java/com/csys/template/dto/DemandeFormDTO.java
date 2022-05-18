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
public class DemandeFormDTO {

    @Size(min = 1, max = 250)
    private String codeForm;
    @Size(min = 1, max = 3)
    private String codeModule;
    @Size(min = 1, max = 15)
    private String codeMenu;
    @Size(min = 1, max = 20)
    private String codeDemande;
    @Size(min = 1, max = 50)
    private String codeControl;
    
    private Boolean valider;
    
    private Boolean validerNew;
    
    private FormDTO form;



    
    public String getCodeForm() {
        return codeForm;
    }

    public void setCodeForm(String codeForm) {
        this.codeForm = codeForm;
    }

    public String getCodeModule() {
        return codeModule;
    }

    public void setCodeModule(String codeModule) {
        this.codeModule = codeModule;
    }

    public String getCodeMenu() {
        return codeMenu;
    }

    public void setCodeMenu(String codeMenu) {
        this.codeMenu = codeMenu;
    }

    public String getCodeDemande() {
        return codeDemande;
    }

    public void setCodeDemande(String codeDemande) {
        this.codeDemande = codeDemande;
    }

    public String getCodeControl() {
        return codeControl;
    }

    public void setCodeControl(String codeControl) {
        this.codeControl = codeControl;
    }

    public Boolean getValiderNew() {
        return validerNew;
    }

    public void setValiderNew(Boolean validerNew) {
        this.validerNew = validerNew;
    }

    public Boolean getValider() {
        return valider;
    }

    public void setValider(Boolean valider) {
        this.valider = valider;
    }

    public FormDTO getForm() {
        return form;
    }

    public void setForm(FormDTO form) {
        this.form = form;
    }



}

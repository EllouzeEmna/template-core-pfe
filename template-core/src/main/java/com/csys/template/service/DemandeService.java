
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.service;

import com.csys.template.domain.Demande;
import com.csys.template.domain.EtatDemandeEnum;
import com.csys.template.domain.Form;
import com.csys.template.domain.MenuP;
import com.csys.template.domain.Module;
import com.csys.template.domain.QDemande;
import com.csys.template.dto.AccessControlDTO;
import com.csys.template.dto.DemandeDTO;
import com.csys.template.dto.DemandeFormDTO;
import com.csys.template.dto.DemandeMenuDTO;
import com.csys.template.dto.DemandeModuleDTO;
import com.csys.template.dto.GroupUserDTO;
import com.csys.template.factory.DemandeFactory;
import com.csys.template.repository.DemandeRepository;
import com.csys.template.repository.FormRepository;
import com.csys.template.repository.MenuPRepository;
import com.csys.template.repository.ModuleRepository;
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
    private final AccessControlService accessControlService;
    private final GroupUserService groupUserService;
    private final FormRepository formRepository;
    private final MenuPRepository menuPRepository;
    private final ModuleRepository moduleRepository;
    private final AccessFormService accessFormService;
    private final AccessFormUserService accessFormUserService;
    private final AccessMenuService accessMenuService;
    private final AccessMenuUserService accessMenuUserService;
    private final AccessModuleService accessModuleService;
    private final AccessModuleUserService accessModuleUserService;

    public DemandeService(DemandeRepository demandeRepository, AccessControlService accessControlService, GroupUserService groupUserService, FormRepository formRepository, MenuPRepository menuPRepository, ModuleRepository moduleRepository, AccessFormService accessFormService, AccessFormUserService accessFormUserService, AccessMenuService accessMenuService, AccessMenuUserService accessMenuUserService, AccessModuleService accessModuleService, AccessModuleUserService accessModuleUserService) {
        this.demandeRepository = demandeRepository;
        this.accessControlService = accessControlService;
        this.groupUserService = groupUserService;
        this.formRepository = formRepository;
        this.menuPRepository = menuPRepository;
        this.moduleRepository = moduleRepository;
        this.accessFormService = accessFormService;
        this.accessFormUserService = accessFormUserService;
        this.accessMenuService = accessMenuService;
        this.accessMenuUserService = accessMenuUserService;
        this.accessModuleService = accessModuleService;
        this.accessModuleUserService = accessModuleUserService;
    }

    @Transactional(
            readOnly = true
    )
    public List<DemandeDTO> findAllDTO(boolean lazy, EtatDemandeEnum etat) {
        log.debug("Request to get All Demandes");
        QDemande qDemande = QDemande.demande;
        WhereClauseBuilder builder;
        builder = new WhereClauseBuilder()
                .optionalAnd(etat, () -> qDemande.etat.eq(etat));
        List<Demande> result = (List<Demande>) demandeRepository.findAll(builder);

        return DemandeFactory.demandeToDemandeDTOs(result, lazy);
    }

    public DemandeDTO findOne(String codeDemande) {
        Demande result = demandeRepository.findOne(codeDemande);
        Preconditions.checkFound(result == null, "user demande et group user not found");

        return DemandeFactory.demandeToDemandeDTO(result, true);
    }

    public DemandeDTO save(DemandeDTO demandeDTO) {
        log.debug("Request to update Demande: {}", demandeDTO);
        Demande demande = DemandeFactory.demandeDTOToDemande(demandeDTO);
        AccessControlDTO userDemande = accessControlService.findAccessControlDTO(demandeDTO.getUserName());
        GroupUserDTO grpUserDemande = groupUserService.findGroupUserDTO(demandeDTO.getUserGrp());
        Preconditions.checkFound(userDemande != null && grpUserDemande != null, "user demande et group user not found");
        if (userDemande != null) {
            demandeDTO.getDemandeFormCollection().forEach(x -> {
                userDemande.getAccessFormUserCollection().forEach(y -> {
                    Preconditions.checkBusinessLogique(!(y.getForm().equals(x.getCodeForm())
                            && y.getCodeMenu().equals(x.getCodeMenu()) && y.getModule().equals(x.getCodeModule())
                            && y.getControl().equals(x.getCodeControl())), "acces Form exist deja.");
                });
            });
            demandeDTO.getDemandeMenuCollection().forEach(x -> {
                userDemande.getAccessMenuUserCollection().forEach(y -> {
                    Preconditions.checkBusinessLogique(!(y.getMenu().equals(x.getCodeMenu())
                            && y.getModule().equals(x.getCodeModule())), "acces Menu exist deja.");
                    // && y.getUser().equals(x.getCodeControl()), "acces Form exist deja.");
                });
            });
            demandeDTO.getDemandeModuleCollection().forEach(x -> {
                userDemande.getModuleCollection().forEach(y -> {
                    Preconditions.checkBusinessLogique(!(y.getNumModule().equals(x.getNumModule())), "acces Module exist deja.");
                    //&& y.getUser.equals(x.getCodeControl()), "acces Form exist deja.");
                });
            });
        } else {
            demandeDTO.getDemandeFormCollection().forEach(x -> {
                grpUserDemande.getAccessFormCollection().forEach(y -> {
                    Preconditions.checkBusinessLogique(!(y.getForm().equals(x.getCodeForm())
                            && y.getCodeMenu().equals(x.getCodeMenu()) && y.getModule().equals(x.getCodeModule())),
                            "acces Form exist deja.");
                });
            });
            demandeDTO.getDemandeMenuCollection().forEach(x -> {
                grpUserDemande.getAccessMenuCollection().forEach(y -> {
                    Preconditions.checkBusinessLogique(!(y.getMenu().equals(x.getCodeMenu())
                            && y.getModule().equals(x.getCodeModule())), "acces Menu exist deja.");
                    // && y.getUser().equals(x.getCodeControl()), "acces Form exist deja.");
                });
            });
            demandeDTO.getDemandeModuleCollection().forEach(x -> {
                grpUserDemande.getModuleCollection().forEach(y -> {
                    Preconditions.checkBusinessLogique(!(y.getNumModule().equals(x.getNumModule())), "acces Module exist deja.");
                    //&& y.getUser.equals(x.getCodeControl()), "acces Form exist deja.");
                });
            });
        }
        List<Form> forms = formRepository.findAll();
        List<MenuP> menuPs = menuPRepository.findAll();
        List<Module> modules = moduleRepository.findAll();
        demandeDTO.getDemandeFormCollection().forEach(x -> {
            forms.forEach(y -> {
                Preconditions.checkBusinessLogique(!(x.getCodeForm().equals(y.getFormPK().getForm())
                        && x.getCodeMenu().equals(y.getFormPK().getCodeMenu()) && x.getCodeModule().equals(y.getFormPK().getControl())), "form n' exist deja.");

            });
        });
        demandeDTO.getDemandeMenuCollection().forEach(x -> {
            menuPs.forEach(y -> {
                Preconditions.checkBusinessLogique(!(x.getCodeMenu().equals(y.getMenuPPK().getCodMnp())
                        && x.getCodeModule().equals(y.getMenuPPK().getModule())), "menu n' exist deja.");

            });
        });
        demandeDTO.getDemandeModuleCollection().forEach(x -> {
            modules.forEach(y -> {
                Preconditions.checkBusinessLogique(!(x.getNumModule().equals(y.getNumModule())), "module n' exist deja.");

            });
        });
        demande = demandeRepository.save(demande);
        DemandeDTO resultDTO = DemandeFactory.demandeToDemandeDTO(demande, true);
        return resultDTO;
    }

    public DemandeDTO update(DemandeDTO demandeDTO) {
        log.debug("Request to update Demande: {}", demandeDTO);
        Demande demande = demandeRepository.findByCodeDemande(demandeDTO.getCodeDemande());
        AccessControlDTO userDemande = accessControlService.findAccessControlDTO(demandeDTO.getUserName());
        GroupUserDTO grpUserDemande = groupUserService.findGroupUserDTO(demandeDTO.getUserGrp());

        Preconditions.checkFound(demande == null, "demande est inexistante.");

        Preconditions.checkBusinessLogique(!(demande.getEtat().equals(EtatDemandeEnum.PartielementValide)), "demande deja partielement valide");
        Preconditions.checkBusinessLogique(!(demande.getEtat().equals(EtatDemandeEnum.Refuser)), "demande deja refuser");
        Preconditions.checkBusinessLogique(!(demande.getEtat().equals(EtatDemandeEnum.Valide)), "demande deja valide");
        Preconditions.checkFound(userDemande != null && grpUserDemande != null, "user demande et group user not found");
        if (userDemande != null) {
            demandeDTO.getDemandeFormCollection().forEach(x -> {
                userDemande.getAccessFormUserCollection().forEach(y -> {
                    Preconditions.checkBusinessLogique(!(y.getForm().equals(x.getCodeForm())
                            && y.getCodeMenu().equals(x.getCodeMenu()) && y.getModule().equals(x.getCodeModule())
                            && y.getControl().equals(x.getCodeControl())), "acces Form exist deja.");
                });
            });
            demandeDTO.getDemandeMenuCollection().forEach(x -> {
                userDemande.getAccessMenuUserCollection().forEach(y -> {
                    Preconditions.checkBusinessLogique(!(y.getMenu().equals(x.getCodeMenu())
                            && y.getModule().equals(x.getCodeModule())), "acces Menu exist deja.");
                });
            });
            demandeDTO.getDemandeModuleCollection().forEach(x -> {
                userDemande.getModuleCollection().forEach(y -> {
                    Preconditions.checkBusinessLogique(!(y.getNumModule().equals(x.getNumModule())), "acces Module exist deja.");
                });
            });
        } else {
            demandeDTO.getDemandeFormCollection().forEach(x -> {
                grpUserDemande.getAccessFormCollection().forEach(y -> {
                    Preconditions.checkBusinessLogique(!(y.getForm().equals(x.getCodeForm())
                            && y.getCodeMenu().equals(x.getCodeMenu()) && y.getModule().equals(x.getCodeModule())),
                            "acces Form exist deja.");
                });
            });
            demandeDTO.getDemandeMenuCollection().forEach(x -> {
                grpUserDemande.getAccessMenuCollection().forEach(y -> {
                    Preconditions.checkBusinessLogique(!(y.getMenu().equals(x.getCodeMenu())
                            && y.getModule().equals(x.getCodeModule())), "acces Menu exist deja.");
                });
            });
            demandeDTO.getDemandeModuleCollection().forEach(x -> {
                grpUserDemande.getModuleCollection().forEach(y -> {
                    Preconditions.checkBusinessLogique(!(y.getNumModule().equals(x.getNumModule())), "acces Module exist deja.");
                });
            });
        }
        demande = demandeRepository.save(DemandeFactory.demandeDTOToDemande(demandeDTO));
        DemandeDTO resultDTO = DemandeFactory.demandeToDemandeDTO(demande, true);
        return resultDTO;
    }

    public DemandeDTO acceptation(DemandeDTO demandeDTO) {
        log.debug("Request to accepter Demande: {}", demandeDTO);
        Demande demande = demandeRepository.findByCodeDemande(demandeDTO.getCodeDemande());
        Preconditions.checkBusinessLogique(!(demande.getEtat().equals(EtatDemandeEnum.Refuser)), "demande deja refuser");
        Preconditions.checkBusinessLogique(!(demande.getEtat().equals(EtatDemandeEnum.Valide)), "demande deja valide");

        GroupUserDTO grpUserDemande = groupUserService.findGroupUserDTO(demandeDTO.getUserGrp());
        AccessControlDTO userDemande = accessControlService.findAccessControlDTO(demandeDTO.getUserName());
        Preconditions.checkFound(userDemande != null && grpUserDemande != null, "user demande et group user not found");

        DemandeDTO demandeInBase = DemandeFactory.demandeToDemandeDTO(demande, true);

        demandeInBase.getDemandeFormCollection().forEach(x -> {
            DemandeFormDTO demandeFormDTO = demandeDTO.getDemandeFormCollection().stream().filter(y -> {
                return y.getCodeForm().equals(x.getCodeForm())
                        && y.getCodeMenu().equals(x.getCodeMenu()) && y.getCodeModule().equals(x.getCodeModule())
                        && y.getCodeControl().equals(x.getCodeControl());
            }).findFirst().orElse(null);
            Preconditions.checkBusinessLogique(demandeFormDTO != null, "demande form inexistant");
            if (!demandeFormDTO.getValider().equals(x.getValider())) {
                x.setValiderNew(Boolean.TRUE);
            } else {
                x.setValiderNew(Boolean.FALSE);
            }
            x.setValider(demandeFormDTO.getValider());

        });
        demandeInBase.getDemandeMenuCollection().forEach(x -> {
            DemandeMenuDTO demandeMenuDTO = demandeDTO.getDemandeMenuCollection().stream().filter(y -> {
                return y.getCodeMenu().equals(x.getCodeMenu()) && y.getCodeModule().equals(x.getCodeModule())
                        && !y.getValider().equals(x.getValider());
            }).findFirst().orElse(null);
            Preconditions.checkBusinessLogique(demandeMenuDTO != null, "demande menu inexistant");
            if (!demandeMenuDTO.getValider().equals(x.getValider())) {
                x.setValiderNew(Boolean.TRUE);
            } else {
                x.setValiderNew(Boolean.FALSE);
            }
            x.setValider(demandeMenuDTO.getValider());
        });
        demandeInBase.getDemandeModuleCollection().forEach(x -> {
            DemandeModuleDTO demandeModuleDTO = demandeDTO.getDemandeModuleCollection().stream().filter(y -> {
                return y.getNumModule().equals(x.getNumModule())
                        && !y.getValider().equals(x.getValider());
            }).findFirst().orElse(null);
            Preconditions.checkBusinessLogique(demandeModuleDTO != null, "demande module inexistant");
            if (!demandeModuleDTO.getValider().equals(x.getValider())) {
                x.setValiderNew(Boolean.TRUE);
            } else {
                x.setValiderNew(Boolean.FALSE);
            }
            x.setValider(demandeModuleDTO.getValider());
        });

        if (userDemande != null) {
            demandeInBase.getDemandeFormCollection().forEach(x -> {
                if (x.getValiderNew()) {
                    userDemande.getAccessFormUserCollection().forEach(y -> {
                        Preconditions.checkBusinessLogique(!(y.getForm().equals(x.getCodeForm())
                                && y.getCodeMenu().equals(x.getCodeMenu()) && y.getModule().equals(x.getCodeModule())
                                && y.getControl().equals(x.getCodeControl())), "acces Form exist deja.");
                    });
                }

            });
            demandeInBase.getDemandeMenuCollection().forEach(x -> {
                if (x.getValiderNew()) {
                    userDemande.getAccessMenuUserCollection().forEach(y -> {
                        Preconditions.checkBusinessLogique(!(y.getMenu().equals(x.getCodeMenu())
                                && y.getModule().equals(x.getCodeModule())), "acces Menu exist deja.");
                    });

                }
            });
            demandeInBase.getDemandeModuleCollection().forEach(x -> {

                if (x.getValiderNew()) {
                    userDemande.getModuleCollection().forEach(y -> {
                        Preconditions.checkBusinessLogique(!(y.getNumModule().equals(x.getNumModule())), "acces Module exist deja.");
                    });

                }
            });

            accessFormUserService.validateAccessDemande((List<DemandeFormDTO>) demandeInBase.getDemandeFormCollection(), userDemande);
            accessMenuUserService.validateAccessDemande((List<DemandeMenuDTO>) demandeInBase.getDemandeMenuCollection(), userDemande);
            accessModuleUserService.validateAccessDemande((List<DemandeModuleDTO>) demandeInBase.getDemandeModuleCollection(), userDemande);

//            accessFormUserService.validateAccessDemande
//            demandeInBase.getDemandeFormCollection().stream().filter(x -> x.getValiderNew()).collect(Collectors.toList());
//            demandeInBase.getDemandeMenuCollection().stream().filter(x -> x.getValider()).forEach(y -> {
//                AccessMenuUser accessMenuUser = new AccessMenuUser();
//                AccessMenuUserPK accessMenuUserPK = new AccessMenuUserPK();
//                accessMenuUserPK.setMenu(y.getMenuP().getMenuPPK().getCodMnp());
//                accessMenuUserPK.setModule(y.getMenuP().getMenuPPK().getModule());
//                accessMenuUser.setAccessMenuUserPK(accessMenuUserPK);
//                accessMenuUser.setMenuP(y.getMenuP());
//                userDemande.getAccessMenuUserCollection().add(AccessMenuUserFactory.accessMenuUserToAccessMenuUserDTO(accessMenuUser));
//            });
//            demandeInBase.getDemandeModuleCollection().stream().filter(x -> x.getValider()).forEach(y -> {
//                userDemande.getModuleCollection().add(ModuleFactory.moduleToModuleDTO(y.getModule()));
//            });
        } else {
            demandeInBase.getDemandeFormCollection().forEach(x -> {
                if (x.getValiderNew()) {
                    grpUserDemande.getAccessFormCollection().forEach(y -> {
                        Preconditions.checkBusinessLogique(!(y.getForm().equals(x.getCodeForm())
                                && y.getCodeMenu().equals(x.getCodeMenu()) && y.getModule().equals(x.getCodeModule())),
                                "acces Form exist deja.");
                    });
                }

            });
            demandeInBase.getDemandeMenuCollection().forEach(x -> {

                if (x.getValiderNew()) {
                    grpUserDemande.getAccessMenuCollection().forEach(y -> {
                        Preconditions.checkBusinessLogique(!(y.getMenu().equals(x.getCodeMenu())
                                && y.getModule().equals(x.getCodeModule())), "acces Menu exist deja.");
                    });
                }

            });
            demandeInBase.getDemandeModuleCollection().forEach(x -> {

                if (x.getValiderNew()) {
                    grpUserDemande.getModuleCollection().forEach(y -> {
                        Preconditions.checkBusinessLogique(!(y.getNumModule().equals(x.getNumModule())), "acces Module exist deja.");
                    });
                }
            });
        }
        accessFormService.validateAccessDemande((List<DemandeFormDTO>) demandeInBase.getDemandeFormCollection(), grpUserDemande);
        accessMenuService.validateAccessDemande((List<DemandeMenuDTO>) demandeInBase.getDemandeMenuCollection(), grpUserDemande);
        accessModuleService.validateAccessDemande((List<DemandeModuleDTO>) demandeInBase.getDemandeModuleCollection(), grpUserDemande);

        Boolean valideTotal = demandeInBase.getDemandeFormCollection().stream().map(DemandeFormDTO::getValider).reduce(Boolean.TRUE, Boolean::logicalAnd)
                && demandeInBase.getDemandeMenuCollection().stream().map(DemandeMenuDTO::getValider).reduce(Boolean.TRUE, Boolean::logicalAnd)
                && demandeInBase.getDemandeModuleCollection().stream().map(DemandeModuleDTO::getValider).reduce(Boolean.TRUE, Boolean::logicalAnd);

        if (valideTotal) {
            demandeInBase.setEtat(EtatDemandeEnum.Valide);
        } else {
            demandeInBase.setEtat(EtatDemandeEnum.PartielementValide);
        }
        demande = demandeRepository.save(DemandeFactory.demandeDTOToDemande(demandeInBase));
        DemandeDTO resultDTO = DemandeFactory.demandeToDemandeDTO(demande, true);
        return resultDTO;

    }

    public void refuserDemande(DemandeDTO demandeDTO) {
        Demande demande = demandeRepository.findByCodeDemande(demandeDTO.getCodeDemande());
        Preconditions.checkFound(demande == null, "demande est inexistante.");
        Preconditions.checkBusinessLogique(!(demande.getEtat().equals(EtatDemandeEnum.PartielementValide)), "demande deja partielement valide");
        Preconditions.checkBusinessLogique(!(demande.getEtat().equals(EtatDemandeEnum.Refuser)), "demande deja refuser");
        Preconditions.checkBusinessLogique(!(demande.getEtat().equals(EtatDemandeEnum.Valide)), "demande deja valide");

        demandeDTO.setEtat(EtatDemandeEnum.Refuser);
        demandeDTO.setMessage("demande refuser");
    }

    public void delete(String codeDemande) {
        log.debug("Request to delete Demande: {}", codeDemande);
        Demande demande = demandeRepository.findByCodeDemande(codeDemande);
        Preconditions.checkFound(demande == null, "demande est inexistante.");
        Preconditions.checkBusinessLogique(!(demande.getEtat().equals(EtatDemandeEnum.PartielementValide)), "demande deja partielement valide");
        Preconditions.checkBusinessLogique(!(demande.getEtat().equals(EtatDemandeEnum.Refuser)), "demande deja refuser");
        Preconditions.checkBusinessLogique(!(demande.getEtat().equals(EtatDemandeEnum.Valide)), "demande deja valide");
        demandeRepository.delete(demande);
    }
}




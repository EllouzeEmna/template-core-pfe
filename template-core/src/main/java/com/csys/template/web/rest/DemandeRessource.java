package com.csys.template.web.rest;

import com.csys.template.domain.EtatDemandeEnum;
import com.csys.template.dto.DemandeDTO;
import com.csys.template.service.DemandeService;
import com.csys.template.util.RestPreconditions;
import java.lang.String;
import java.lang.Void;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing Demande.
 */
@RestController
@RequestMapping("/api")
public class DemandeRessource {

    private static final String ENTITY_NAME = "demande";

    private final DemandeService demandeService;

    private final Logger log = LoggerFactory.getLogger(DemandeService.class);

    public DemandeRessource(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    /**
     * POST /demandes : Create a new demande.
     *
     * @param demandeDTO
     * @param bindingResult
     * @return the ResponseEntity with status 201 (Created) and with body the
     * new demande, or with status 400 (Bad Request) if the demande has already
     * an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     * @throws org.springframework.web.bind.MethodArgumentNotValidException
     */
    @PostMapping("/demandes")
    public ResponseEntity<DemandeDTO> createDemande(@Valid @RequestBody DemandeDTO demandeDTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        log.debug("REST request to save Demande : {}", demandeDTO);
        if (demandeDTO.getCodeDemande() != null || !demandeDTO.getCodeDemande().isEmpty()) {
            bindingResult.addError(new FieldError("DemandeDTO", "codeDemande", "POST method does not accepte " + ENTITY_NAME + " with code"));
            throw new MethodArgumentNotValidException(null, bindingResult);
        }
        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResult);
        }
        DemandeDTO result = demandeService.save(demandeDTO);
        return ResponseEntity.created(new URI("/api/demandes/" + result.getCodeDemande())).body(result);
    }

    /**
     * PUT /demandes : Updates an existing demande.
     *
     * @param id
     * @param demandeDTO the demande to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated
     * demande, or with status 400 (Bad Request) if the demande is not valid, or
     * with status 500 (Internal Server Error) if the demande couldn't be
     * updated
     * @throws org.springframework.web.bind.MethodArgumentNotValidException
     */
    @PutMapping("/demandes/{id}")
    public ResponseEntity<DemandeDTO> updateDemande(@PathVariable String id, @Valid @RequestBody DemandeDTO demandeDTO) throws MethodArgumentNotValidException {
        log.debug("Request to update Demande: {}", id);
        demandeDTO.setCodeDemande(id);
        DemandeDTO result = demandeService.update(demandeDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * GET /demandes/{id} : get the "id" demande.
     *
     * @param id the id of the demande to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body of demande,
     * or with status 404 (Not Found)
     */
    @GetMapping("/demandes/{id}")
    public ResponseEntity<DemandeDTO> getDemande(@PathVariable String id) {
        log.debug("Request to get Demande: {}", id);
        DemandeDTO dto = demandeService.findOne(id);
        RestPreconditions.checkFound(dto, "demande.NotFound");
        return ResponseEntity.ok().body(dto);
    }

    /**
     * GET /demandes : get all the demandes.
     *
     * @param lazy
     * @param etat
     * @return the ResponseEntity with status 200 (OK) and the list of demandes
     * in body
     */
    @GetMapping("/demandes")
    public List<DemandeDTO> findAllByEtat(@RequestParam boolean lazy, @RequestParam(required = false) EtatDemandeEnum etat) {
        return demandeService.findAllDTO(lazy, etat);
    }

    /**
     * DELETE /demandes/{id} : delete the "id" demande.
     *
     * @param id the id of the demande to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/demandes/{id}")
    public ResponseEntity<Void> deleteDemande(@PathVariable String id) {
        log.debug("Request to delete Demande: {}", id);
        demandeService.delete(id);
        return ResponseEntity.ok().build();
    }
}

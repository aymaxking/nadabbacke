package com.barbour.pfa.pfa.rest;

import com.barbour.pfa.pfa.dao.CompteRepo;
import com.barbour.pfa.pfa.dao.DepenseRepo;
import com.barbour.pfa.pfa.dao.ParticipantRepo;
import com.barbour.pfa.pfa.dao.UserRepo;
import com.barbour.pfa.pfa.models.Compte;
import com.barbour.pfa.pfa.models.Depense;
import com.barbour.pfa.pfa.models.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class DepenseController {
    @Autowired
    DepenseRepo depenseRepo;
    @Autowired
    ParticipantRepo participantRepo;
    @Autowired
    CompteRepo compteRepo;
    @PostMapping("/depenses")
    public ResponseEntity<Object> add(@RequestBody Depense depense) {
        depense.setParticipant(participantRepo.getById(depense.getIdparticipant()));
        depense.setCompte(compteRepo.getById(depense.getIdcompte()));
        depenseRepo.save(depense);
        return new ResponseEntity<>("{\"result\":\"done\"}",
                HttpStatus.OK);       }

    @GetMapping(value = "/depenses",produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Depense> getAll() {
        return depenseRepo.findAll();
    }

    @GetMapping(value = "/depenses/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long voId) {
        Depense voFound = depenseRepo.getById(voId);
        if (voFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(voFound, HttpStatus.OK);
    }
}

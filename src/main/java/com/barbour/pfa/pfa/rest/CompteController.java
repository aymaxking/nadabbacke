package com.barbour.pfa.pfa.rest;

import com.barbour.pfa.pfa.dao.CompteRepo;
import com.barbour.pfa.pfa.dao.DepenseRepo;
import com.barbour.pfa.pfa.dao.ParticipantRepo;
import com.barbour.pfa.pfa.dao.UserRepo;
import com.barbour.pfa.pfa.models.Compte;
import com.barbour.pfa.pfa.models.Depense;
import com.barbour.pfa.pfa.models.Participant;
import com.barbour.pfa.pfa.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")

public class CompteController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    CompteRepo compteRepo;
    @Autowired
    DepenseRepo depenseRepo;
    @Autowired
    ParticipantRepo participantRepo;
    @GetMapping(value = "/comptes",produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Compte> getAll() {
        return compteRepo.findAll();
    }

    @GetMapping(value = "/comptes/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long voId) {
        Compte voFound = compteRepo.getById(voId);
        if (voFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(voFound, HttpStatus.OK);
    }

    @GetMapping(value = "/comptes/user/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Compte> getByUser(@PathVariable(value = "id") Long voId) {
        List<Compte> comptes = new ArrayList<>();
        Double total=0.0;
        User current = userRepo.getById(voId);
        for(Compte c:compteRepo.findAll()){
            for(Participant p:c.getParticipants()){
                total=0.0;
                for(Depense d:depenseRepo.findAll()){
                    if(d.getCompte().getId()==c.getId()&&d.getParticipant().getId()==p.getId()) total+=d.getMontant();
                }
                p.setDepenses(total);
                if(p.getEmail()!=null&&current.getLogin()!=null)
                if(p.getEmail().equals(current.getLogin())){
                    comptes.add(c);
                }
            }
        }
        return comptes;
    }

    @PostMapping(value = "/comptes")
    public ResponseEntity<Object> createAbsence(@Validated @RequestBody Compte vo) {
        User admin = userRepo.findById(vo.getAdminid()).get();
        vo.setParticipants(new ArrayList<Participant>());
        vo.getParticipants().add(new Participant(admin.getNom(),admin.getPrenom(),admin.getLogin(),admin.getTelephone()));
        compteRepo.save(vo);
        return new ResponseEntity<>("{\"result\":\"done\"}",
                HttpStatus.OK);      }

    @PutMapping(value="/comptes/{id}/addparticipant")
    public ResponseEntity<Object> addparticipant(@PathVariable(name = "id") Long id,@RequestBody Participant participant) {
        Compte found = compteRepo.getById(id);
        if (found == null)
            return new ResponseEntity<>("not found", HttpStatus.OK);
        found.addparticipant(participant);
        compteRepo.save(found);
        return new ResponseEntity<>("{\"result\":\"done\"}",
                HttpStatus.OK);    }

    @DeleteMapping(value = "/comptes/{id}")
    public ResponseEntity<Object> k(@PathVariable(name = "id") Long voId) {
        Compte voFound = compteRepo.getById(voId);
        if (voFound == null)
            return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
        compteRepo.delete(voFound);
        return new ResponseEntity<>("{\"result\":\"done\"}",
                HttpStatus.OK);      }





}

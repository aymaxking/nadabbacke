package com.barbour.pfa.pfa.rest;

import com.barbour.pfa.pfa.dao.CompteRepo;
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
public class UserController {
    @Autowired
    UserRepo userRepo;
    @GetMapping(value = "/users",produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @GetMapping(value = "/users/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long voId) {
        User voFound = userRepo.findById(voId).get();
        if (voFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(voFound, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> add(@RequestBody User user) {
        userRepo.save(user);
        return  new ResponseEntity<>("Depense Added", HttpStatus.OK);
    }

}

package com.barbour.pfa.pfa.rest;

import com.barbour.pfa.pfa.dao.UserRepo;
import com.barbour.pfa.pfa.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class Login {
    @Autowired
    UserRepo userRepo;
    @PostMapping(value="/login")
    public ResponseEntity<Object> login(@RequestBody User vo) {
        User found = userRepo.findByLoginEqualsAndPasswordEquals(vo.getLogin(),vo.getPassword());
        if (found == null)
        return new ResponseEntity<>("{\"result\":\"not found\"}",
                HttpStatus.OK);
        return  new ResponseEntity<>(found, HttpStatus.OK);
    }
}

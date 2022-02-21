package com.barbour.pfa.pfa;

import com.barbour.pfa.pfa.models.Compte;
import com.barbour.pfa.pfa.models.Depense;
import com.barbour.pfa.pfa.models.Participant;
import com.barbour.pfa.pfa.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class PfaApplication implements CommandLineRunner {
      @Autowired
      private RepositoryRestConfiguration repositoryRestConfiguration;
    public static void main(String[] args) {
        SpringApplication.run(PfaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      repositoryRestConfiguration.exposeIdsFor(Compte.class);
        repositoryRestConfiguration.exposeIdsFor(Depense.class);
        repositoryRestConfiguration.exposeIdsFor(Participant.class);
        repositoryRestConfiguration.exposeIdsFor(User.class);
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.tp1.rest;

import com.fst.tp1.domain.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hp
 */
@RestController
@RequestMapping("/compte-api")
public class CompteRest {

    @Autowired
    private CompteService compteService;

    @GetMapping("/debiter/reference/{reference}/montant/{montant}")
    public int debiter(@PathVariable("reference") String reference, @PathVariable("montant") Double montant) {
        return compteService.debiter(reference, montant);
    }

    @GetMapping("/crediter/reference/{reference}/montant/{montant}")
    public int crediter(String reference, Double montant) {
        return compteService.crediter(reference, montant);
    }

    @GetMapping("/init")
    public void initDb() {
        compteService.initDb();
    }

    public CompteService getCompteService() {
        return compteService;
    }

    public void setCompteService(CompteService compteService) {
        this.compteService = compteService;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.tp1.domain.service.impl;

import com.fst.tp1.bean.Compte;
import com.fst.tp1.domain.dao.CompteDao;
import com.fst.tp1.domain.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hp
 */
@Service
public class CompteServiceImpl implements CompteService {

    @Autowired
    private CompteDao compteDao;

    @Override
    public int debiter(String reference, Double montant) {
        Compte compte = compteDao.findByReference(reference);
        if (compte == null) {
            return -1;
        } else if (compte.getSolde() < montant) {
            return -2;
        } else {
            Double nvSolde = compte.getSolde() - montant;
            compte.setSolde(nvSolde);
            compteDao.save(compte);
            return 1;
        }
    }

    @Override
    public int crediter(String reference, Double montant) {
        Compte compte = compteDao.findByReference(reference);
        if (compte == null) {
            return -1;
        } else {
            Double nvSolde = compte.getSolde() + montant;
            compte.setSolde(nvSolde);
            compteDao.save(compte);
            return 1;
        }
    }

    @Override
    public void initDb() {
        for (int i = 1; i < 11; i++) {
            Compte c = new Compte("EE" + i, Double.parseDouble("" + (i + 100)));
            compteDao.save(c);
        }
    }

    public CompteDao getCompteDao() {
        return compteDao;
    }

    public void setCompteDao(CompteDao compteDao) {
        this.compteDao = compteDao;
    }

}

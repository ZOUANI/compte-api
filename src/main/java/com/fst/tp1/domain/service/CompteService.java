/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.tp1.domain.service;

/**
 *
 * @author Hp
 */
public interface CompteService {

    public int debiter(String reference, Double montant);

    public int crediter(String reference, Double montant);
    
    public void initDb();
}

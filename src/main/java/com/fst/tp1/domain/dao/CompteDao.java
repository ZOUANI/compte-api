/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.tp1.domain.dao;

import com.fst.tp1.bean.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Hp
 */
@Repository
public interface CompteDao extends JpaRepository<Compte, Long> {

    public Compte findByReference(String reference);
}

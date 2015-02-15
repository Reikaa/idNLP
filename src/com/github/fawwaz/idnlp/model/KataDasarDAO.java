/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fawwaz.idnlp.model;

import com.github.fawwaz.idnlp.model.*;
import com.github.fawwaz.idnlp.model.DAOException;
/**
 *
 * @author Asus
 */
public interface KataDasarDAO {
    public KataDasar find(Long id) throws DAOException;
    public KataDasar find(String katadasar) throws DAOException;
    public boolean isExist(String katadasar) throws DAOException;
}

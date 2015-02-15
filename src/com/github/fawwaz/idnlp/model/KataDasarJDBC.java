/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fawwaz.idnlp.model;

import static com.github.fawwaz.idnlp.model.DAOUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Fawwaz Muhammad
 */
public class KataDasarJDBC implements KataDasarDAO{
    
    // --- Constants ---
    private static final String SQL_FIND_BY_ID = 
            "SELECT id_katadasar,katadasar,tipe_katadasar FROM tb_katadasar WHERE id_katadasar = ?";
    private static final String SQL_FIND_BY_KATADASAR = 
            "SELECT id_katadasar,katadasar,tipe_katadasar FROM tb_katadasar WHERE katadasar = ?";
    private static final String SQL_EXIST_EMAIL =
            "SELECT id_katadasar FROM tb_katadasar WHERE katadasar = ?";
    // --- Vars ---
    private DAOFactory daofactory;
    
    public KataDasarJDBC(DAOFactory daofactory){
        this.daofactory = daofactory;
    }
    
    @Override
    public KataDasar find(Long id) throws DAOException {
        return find(SQL_FIND_BY_ID, id);
    }

    @Override
    public KataDasar find(String katadasar) throws DAOException {
        return find(SQL_FIND_BY_KATADASAR, katadasar);
    }
    
     private KataDasar find(String sql, Object... values) throws DAOException{
       KataDasar katadasar = null;
       try{
           Connection connection        = daofactory.getConnection();
           PreparedStatement statement  = prepareStatement(connection,sql,false,values);
           ResultSet resultset          = statement.executeQuery();
           
           // DISINI BEDA MEN BINGUNG
           if(resultset.next()){
               katadasar = map(resultset);
           }
       }catch (SQLException e){
           throw new DAOException(e);
       }
       
       return katadasar;
    }

    @Override
    public boolean isExist(String katadasar) throws DAOException {
        Object[] values = {katadasar};
        boolean exist   = false;
        
        try (
                Connection connection = daofactory.getConnection();
                PreparedStatement statement = prepareStatement(connection, SQL_EXIST_EMAIL, false, values);
                ResultSet resultSet = statement.executeQuery();) {
                exist = resultSet.next();
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return exist;
    }

    private KataDasar map(ResultSet resultset) throws SQLException{
        KataDasar katadasar = new KataDasar();
        katadasar.setId_katadasar(resultset.getLong("id_katadasar"));
        katadasar.setKatadasar(resultset.getString("katadasar"));
        katadasar.setTipe_katadasar(resultset.getString("tipe_katadasar"));
        return katadasar;
    }
    
}

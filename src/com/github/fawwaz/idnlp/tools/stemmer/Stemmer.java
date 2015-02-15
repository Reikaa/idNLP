/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fawwaz.idnlp.tools.stemmer;

import com.github.fawwaz.idnlp.model.DAOFactory;
import com.github.fawwaz.idnlp.model.KataDasarDAO;

/**
 *
 * @author Fawwaz Muhammad
 * Based on Andriani Stemmer
 */
public class Stemmer {
    
    public String doStemming(String input){
        // Tahap 1
        if(isRootWordsExist(input)){
            return input;
        }
        
        // Tahap 2
        System.out.println(isRootWordsExist(input));
        return "";
    }
    
    // --- Private Functions --- 
    private boolean isRootWordsExist(String input){
        DAOFactory javabase = DAOFactory.getInstance("javabase.jdbc");
        System.out.println("DAOFactory successfully obtained: " + javabase);
        
        KataDasarDAO katadasarDAO = javabase.getKataDasarDAO();
        System.out.println("UserDAO successfully obtained: " + katadasarDAO);
        
        return katadasarDAO.isExist(input);
    }
    /*
    private String Remove_Particle(String str) {
        
        if (str.endsWith("lah")) {
            if (stringMeasure(str.substring(0, str.length() - 3)) >= 1) {
                return str.substring(0, str.length() - 3);
            } else {
                return str;
            }

        } else if (str.endsWith("kah")) {
            if (stringMeasure(str.substring(0, str.length() - 3)) >= 1) {
                return str.substring(0, str.length() - 3);
            } else {
                return str;
            }

        } else if (str.endsWith("tan")) {
            if (stringMeasure(str.substring(0, str.length() - 3)) >= 1) {
                return str.substring(0, str.length() - 3);
            } else {
                return str;
            }

        } else if (str.endsWith("pun")) {
            if (stringMeasure(str.substring(0, str.length() - 3)) >= 1) {
                return str.substring(0, str.length() - 3);
            } else {
                return str;
            }
        } else {
            return str;
        }
    }*/
}

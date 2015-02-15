/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fawwaz.idnlp.tools.sentencesplitter;

import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class EndOfSentenceScanner implements EndOfSentenceScannerInterface{
    
    // --- vars ---
    private ArrayList<String> eosChars;
    
    public EndOfSentenceScanner() {
        eosChars = new ArrayList<>();
        eosChars.add(".");
        eosChars.add("?");
        eosChars.add("!");
    }
    
    public EndOfSentenceScanner(ArrayList<String> array) {
        eosChars = array;
    }

    @Override
    public ArrayList<String> getEndOfSentenceCharacters() {
        return eosChars;
    }

    @Override
    public ArrayList<Integer> getPositions(String string) {
        ArrayList<Integer> retval = new ArrayList<>();
        
        for (int i = 0; i < eosChars.size(); i++) {
            int index = 0;
            while ((index = string.indexOf(eosChars.get(i), index)) != -1) {
                index = string.indexOf(eosChars.get(i), index);
                retval.add(index);
                index++;
            }
        }
        return retval;
    }
    
}

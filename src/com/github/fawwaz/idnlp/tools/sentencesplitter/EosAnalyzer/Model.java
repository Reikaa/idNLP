/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fawwaz.idnlp.tools.sentencesplitter.EosAnalyzer;

import java.util.ArrayList;
/**
 *
 * @author Asus
 */
public class Model {
    // --- Vars ---
    private String text;
    private ArrayList<Integer> eospositions;
    private Integer position;

    public Model(String _text, ArrayList<Integer> _eospositions,Integer _position) {
        this.text = _text;
        this.eospositions = _eospositions;
        this.position = _position;
    }

    public String getText() {
        return text;
    }

    public ArrayList<Integer> getEospositions() {
        return eospositions;
    }

    public Integer getPosition() {
        return position;
    }
    
    
    
}

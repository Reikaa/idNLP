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
public class AnalyzerRepetitiveEos implements AnalyzerInterface{

    public AnalyzerRepetitiveEos() {
        
    }

    @Override
    public boolean shouldSplit(Model model) {
        ArrayList<Integer> eos = model.getEospositions();
        int i = eos.indexOf(model.getPosition());
        
        if(i==-1){
            // if not found
            return true;
        }
        
        if ( (i< (eos.size()-1))&& (eos.get(i+1) == eos.get(i)+1) ){
            return false;
        }
        
        return true;
    }
    
}

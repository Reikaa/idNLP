/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fawwaz.idnlp.tools.sentencesplitter.EosAnalyzer;

/**
 *
 * @author Asus
 */
public class AnalyzerNumericSeparator implements AnalyzerInterface{

    @Override
    public boolean shouldSplit(Model model) {
        Integer position = model.getPosition();
        String text = model.getText();
        if((position!=0) && (position < (text.length() -1)) ){
            String prevchar = text.substring(position-1,position);
            String nextchar = text.substring(position+1,position+2);
            
            if(isNumeric(prevchar) && isNumeric(nextchar)){
                return false;
            }
        }
        return true;
    }
    
    private boolean isNumeric(String s){
        return s.matches("[-+]?\\d*\\.?\\d+");
    }
    
}

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
public class AnalyzerLeadingEos implements AnalyzerInterface {

    public AnalyzerLeadingEos() {
        
    }

    @Override
    public boolean shouldSplit(Model model) {
        String temp = model.getText().substring(0, model.getPosition());
        if(temp.trim().equals("")){
            return false;
        }
        return true;
    }

}

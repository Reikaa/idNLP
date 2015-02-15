/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fawwaz.idnlp.tools.sentencesplitter;

import com.github.fawwaz.idnlp.tools.sentencesplitter.EosAnalyzer.*;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
class FuzzyEndOfSentenceScanner implements EndOfSentenceScannerInterface {

    // --- Vars ---
    private EndOfSentenceScanner defaultscanner;
    private ArrayList<AnalyzerInterface> eosanalyzers;
    
    
    public FuzzyEndOfSentenceScanner() {
        this.defaultscanner = new EndOfSentenceScanner();
        this.addEosAnalyzer(new AnalyzerRepetitiveEos());
        this.addEosAnalyzer(new AnalyzerLeadingEos());
        this.addEosAnalyzer(new AnalyzerNumericSeparator());
        // this.addEosAnalyzer(new AnalyzerEmailAddress()); // For SimlictyIGNORE First
        //this.addEosAnalyzer(new AnalyzerAbbreviations()); // For Simplicity Ignore this case first
        //this.addEosAnalyzer(new AnalyzerHostname()); // For simplicity Ignore first
        //this.addEosAnalyzer(new AnalyzerUrl()); // For Simplicity IGNORE First 
        
        
        
        /* HARUSNYA diaktifkan
        if(eosanalyzers!=null){ 
            this.addEosAnalyzers(eosanalyzers);
        }*/
    }
    
    public void addEosAnalyzers(ArrayList<AnalyzerInterface> analyzers){
        for(AnalyzerInterface analyzer : analyzers){
            addEosAnalyzer(analyzer);
        }
    }
    
    public void addEosAnalyzer(AnalyzerInterface analyzer){
        this.eosanalyzers.add(analyzer);
    }

    public ArrayList<AnalyzerInterface> getEosanalyzers() {
        return eosanalyzers;
    }
    
    
    @Override
    public ArrayList<String> getEndOfSentenceCharacters() {
        return this.defaultscanner.getEndOfSentenceCharacters();
    }

    @Override
    public ArrayList<Integer> getPositions(String string) {
        ArrayList<Integer> endpositions = this.defaultscanner.getPositions(string);
        ArrayList<Integer> candidates   = new ArrayList<>();
        
        for (int i = 0; i < endpositions.size(); i++) {
            if(shouldsplit(string,endpositions,endpositions.get(i))){
                candidates.add(endpositions.get(i));
            }
        }
        
        return candidates;
    }
    
    public boolean shouldsplit(String text, ArrayList<Integer> eospositions,Integer position){
        Model model = new Model(text, eospositions, position);
        
        for(AnalyzerInterface analyzer: this.eosanalyzers){
            if(analyzer.shouldSplit(model)==false){
                return false;
            }
        }
        
        return true;
    }
}

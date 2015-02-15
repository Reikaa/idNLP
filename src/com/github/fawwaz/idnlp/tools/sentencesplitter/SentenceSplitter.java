/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fawwaz.idnlp.tools.sentencesplitter;

import com.github.fawwaz.idnlp.tools.span.Span;
import com.github.fawwaz.idnlp.tools.span.SpanException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class SentenceSplitter implements SentenceSplitterInterface{

    
    private EndOfSentenceScannerInterface eosscanner;
    SentenceSplitter(EndOfSentenceScannerInterface fuzzyEndOfSentenceScanner) {
        this.eosscanner = fuzzyEndOfSentenceScanner;
    }

    @Override
    public ArrayList<String> detect(String string) {
        ArrayList<Span> spans = this.detectPositions(string);
        ArrayList<String> sentences = new ArrayList<>();
        for (Span span : spans) {
            sentences.add(span.getCoveredText(string));
        }
        return sentences;
                
    }

    @Override
    public ArrayList<Span> detectPositions(String string) {
        ArrayList<Integer> positions = this.eosscanner.getPositions(string);
        ArrayList<Span> spans = new ArrayList<>();
        int start,end;
        
        // string does not contain any sentence end positions
        if(positions.size()==0){
            start   = StringUtil.getNextNonWhiteSpace(string);
            end     = StringUtil.getPrevNonWhiteSpace(string);
            
            if(end-start>0){
                try {
                    spans.add(new Span(start, end+1));
                } catch (SpanException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            return spans;
        }
        
        for(int i=0; i<positions.size(); i++){
            if(i==0){
                start = StringUtil.getNextNonWhiteSpace(string);
            }else{
                 // start from previous eos position + 1 exactly 1 character after
                start = positions.get(i-1) + 1;
                if(string.substring(positions.get(i-1)+1,positions.get(i-1)+2).equals("\"")){
                    start++;
                }
                start = StringUtil.getNextNonWhiteSpace(string,start-1);
            }
            
            end = StringUtil.getPrevNonWhiteSpace(string,positions.get(i));
            end++;
            
            if(end<string.length()-1){
                if(string.substring(end+1,end+2).equals("\"")){
                    end++;
                }
            }
            
            if(end<start){
                end = start;
            }
            try {
                spans.add(new Span(start, end+1));
            } catch (SpanException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        Span leftover = this.getLeftOverSpan(string,positions);
        if(leftover!=null){
            spans.add(leftover);
        }
        return spans;
        
    }
    
    private Span getLeftOverSpan(String string,ArrayList<Integer> positions){
        if(positions.get(positions.size()-1) != string.length() -1){
            int start = StringUtil.getNextNonWhiteSpace(string,positions.get(positions.size()-1));
            int end = StringUtil.getPrevNonWhiteSpace(string);
            
            if((start != -1 ) && (end-start >0)){
                try {
                    return new Span(start,end+1);
                } catch (SpanException ex) {
                    System.out.println(ex.getMessage());
                }
            }        
        }else{
            return null;
        }
        return null;
    }
}

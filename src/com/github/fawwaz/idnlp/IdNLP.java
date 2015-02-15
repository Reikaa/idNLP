/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fawwaz.idnlp;

import com.github.fawwaz.idnlp.tools.sentencesplitter.SentenceSplitter;
import com.github.fawwaz.idnlp.tools.sentencesplitter.SentenceSplitterFactory;
import com.github.fawwaz.idnlp.tools.stemmer.Stemmer;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class IdNLP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String input = "ngetesdoang";
        Stemmer stemmer = new Stemmer();
        SentenceSplitterFactory ssfactory = new SentenceSplitterFactory();
        SentenceSplitter ssplitter = ssfactory.getSentenceSplitter();
        String text = "Saya belajar NLP Bahasa Indonesia.";
        ArrayList<String> sentences = ssplitter.detect(text);
        for (int i = 0; i < sentences.size(); i++) {
            System.out.println(i+" : "+sentences.get(i));
            
        }
        
        String output = stemmer.doStemming(input);
        
        System.out.println(output);
    }
    
}

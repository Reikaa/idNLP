/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fawwaz.idnlp.tools.sentencesplitter;

/**
 *
 * @author Asus
 */
public class SentenceSplitterFactory {
    public SentenceSplitter getSentenceSplitter(){
        return new SentenceSplitter(new FuzzyEndOfSentenceScanner());
    }
}

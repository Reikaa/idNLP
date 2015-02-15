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
public interface EndOfSentenceScannerInterface {
    public ArrayList<String> getEndOfSentenceCharacters();
    public ArrayList<Integer> getPositions(String string);
}

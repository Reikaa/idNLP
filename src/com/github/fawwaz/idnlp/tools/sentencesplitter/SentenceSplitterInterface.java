/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fawwaz.idnlp.tools.sentencesplitter;

import java.util.ArrayList;
import com.github.fawwaz.idnlp.tools.span.Span;
/**
 *
 * @author Asus
 */
public interface SentenceSplitterInterface {
    public ArrayList<String> detect(String string);
    public ArrayList<Span> detectPositions(String string);
}

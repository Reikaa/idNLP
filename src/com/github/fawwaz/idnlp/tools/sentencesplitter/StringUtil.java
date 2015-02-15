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
public class StringUtil {

    private static String[] WhiteSpaceChars = {" ", "\t", "\n"};
    private static String[] standardEosChars = {".", "?", "!"};

    public static boolean isWhiteSpace(char ch) {
        return Character.isWhitespace(ch);
    }

    public static Integer getNextWhiteSpace(String string) {
        return getNextWhiteSpace(string, -1);
    }

    public static Integer getNextWhiteSpace(String string, Integer start) {
        while ((start < (string.length() - 1)) && !isWhiteSpace(string.charAt(start + 1))) {
            start++;
        }

        if (start == (string.length() - 1)) {
            return -1; // false
        }

        start++;
        return start;
    }

    public static Integer getPrevWhiteSpace(String string) {
        return getPrevWhiteSpace(string, null);
    }

    public static Integer getPrevWhiteSpace(String string, Integer start) {
        int _start;
        if (start != null) {
            _start = start;
        } else {
            _start = string.length();
        }

        while ((_start > 0) && (!isWhiteSpace(string.charAt(_start - 1)))) {
            _start--;
        }

        if (_start == 0) {
            return -1; // false
        }

        _start--;
        return _start;
    }

    public static Integer getNextNonWhiteSpace(String string) {
        return getNextNonWhiteSpace(string, -1);
    }

    public static Integer getNextNonWhiteSpace(String string, Integer start) {
        while (start < (string.length() - 1) && isWhiteSpace(string.charAt(start+1))) {
            start++;
        }
        
        if (start == (string.length() - 1)) {
            return -1; // false
        }
        
        start++;
        return start;
    }
    
    public static Integer getPrevNonWhiteSpace(String string) {
        return getPrevNonWhiteSpace(string,null);
    }
    
    public static Integer getPrevNonWhiteSpace(String string, Integer start) {
        int _start;
        if(start!=null){
            _start = start;
        }else{
            _start = string.length();
        }
        
        while (start > 0 && isWhiteSpace(string.charAt(start-1))) {
            start--;
        }
        
        if (start == 0) {
            return -1; // false
        }
        
        start--;
        return start;
    }
    
    public static String[] getStandardEosChars(){
        return standardEosChars;
    }
    
}

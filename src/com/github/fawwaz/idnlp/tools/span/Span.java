/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fawwaz.idnlp.tools.span;

/**
 *
 * @author Fawwaz Muhammad implements 
 */
public class Span implements SpanInterface{
    
    // --- Vars ---
    private int start = 0;
    private int end = 0;
    private String type;

    public Span(int start, int end) throws SpanException{
        if(start<0){
            throw new SpanException("start must be positive given start value:"+start);
        }
        if(end<0){
            throw new SpanException("end must be positive given start value:"+end);
        }
        if(start>end){
            throw new SpanException("start index must be greater than end index given start value:"+start+" and end value :"+end);
        }
        this.start = start;
        this.end = end;
    }
    
    public Span(int start, int end, String type) throws SpanException{
        if(start<0){
            throw new SpanException("start must be positive given start value:"+start);
        }
        if(end<0){
            throw new SpanException("end must be positive given start value:"+end);
        }
        if(start>end){
            throw new SpanException("start index must be greater than end index given start value:"+start+" and end value :"+end);
        }
        this.start = start;
        this.end = end;
        this.type = type;
    }
    
    @Override
    public int getStart() {
        return this.start;
    }

    @Override
    public int getEnd() {
        return this.end;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public int getLength() {
        return this.end - this.start;
    }

    @Override
    public String getCoveredText(String text) {
        return text.substring(start, end);
    }

    @Override
    public boolean contains(SpanInterface span) {
        return (this.start <= span.getStart()) && (span.getEnd() <= this.end);
    }

    @Override
    public boolean containsIndex(int index) {
        return (this.start <= index) && (index <= this.end);
    }

    @Override
    public boolean startsWith(SpanInterface span) {
        return (this.start == span.getStart()) && this.contains(span);
    }

    @Override
    public boolean intersects(SpanInterface span) {
        int sstart = span.getStart();
        
        return  (this.contains(span)) ||
                (span.contains(this)) ||
                ((this.start <= sstart) && (sstart <this.end)) ||
                ((sstart <= this.start) && (this.start < span.getEnd()));
    }

    @Override
    public boolean crosses(SpanInterface span) {
        int sstart = span.getStart();
        
        return !this.contains(span) &&
               !span.contains(this) &&
               ((this.start <= sstart) && (sstart < this.end))||
               ((sstart <= this.start) && (this.start<span.getEnd()));
    }

    public String toString(){
        String retval = "["+this.start+".."+this.end+")";
        if(this.getType()!=null){
            retval = retval + ' '+this.getType();
        }
        return retval;
    }
    
}

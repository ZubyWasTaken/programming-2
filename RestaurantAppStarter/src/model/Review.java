/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mga
 */
public class Review {
    
    private String reviewer;
    private int rating;
    
    static final char EOLN='\n';       
    static final String QUOTE="\""; 

    /**
     *
     */
    public Review() {
        this.reviewer = "TBC";
        this.rating = 0;
    }

    /**
     *
     * @param reviewer
     * @param rating
     */
    public Review(String reviewer, int rating) {
        this.reviewer = reviewer;
        this.rating = rating;
    }
    
    // Methods required: getters, setters

    /**
     *
     * @return
     */
    
    @Override
    public String toString() {
        return "Review{" + "reviewer=" + reviewer + ", rating=" + Integer.toString(rating) + '}';
    }   
}

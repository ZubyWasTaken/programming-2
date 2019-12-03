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

    static final char EOLN = '\n';
    static final String QUOTE = "\"";

    // creates review object with a reviewer name to be set, and rating as 0.
    /**
     *
     */
    public Review() {
        this.reviewer = "TBC";
        this.rating = 0;
    }

    // creates a review with the reviewer and rating set by values passed in.
    /**
     *
     * @param reviewer
     * @param rating
     */
    public Review(String reviewer, int rating) {
        this.reviewer = reviewer;
        this.rating = rating;
    }

    
    // returns the reviewer name.
    /**
     *
     * @return
     */
    public String getReviewer() {
        return reviewer;
    }

    // sets the reviewers name with the value passed in.
    /**
     *
     * @param reviewer
     */
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    // returns the rating.
    /**
     *
     * @return
     */
    public int getRating() {
        return rating;
    }

    // sets the rating
    /**
     *
     * @param rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    // converts the review to a string and returns it formatted.
    /**
     *
     * @param delimiter
     * @return
     */
    public String toString(char delimiter) {
        String output = QUOTE + this.reviewer + QUOTE + delimiter + Integer.toString(this.rating) + EOLN;
        return output;
    }

    // converts review to string and returns.
    @Override
    public String toString() {
        return "Review{" + "reviewer=" + reviewer + ", rating=" + Integer.toString(rating) + '}';
    }
}

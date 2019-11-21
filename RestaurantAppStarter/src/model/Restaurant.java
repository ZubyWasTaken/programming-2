/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author mga
 */
public class Restaurant {
    private final int id;
    private String name;
    private String location;
    private List<Review> reviewsCollection;
    
    private static int lastIdAllocated = 0;
    
    static final char EOLN='\n';       
    static final String QUOTE="\""; 
    
    public static Comparator<Restaurant> RestaurantNameComparator = (Restaurant rest1, Restaurant rest2) -> {
        String restName1 = rest1.getName();
        String restName2 = rest2.getName();
        
        return restName1.compareTo(restName2);
    };
    
    
    /**
     *
     */
    public Restaurant() {
        this.id = ++lastIdAllocated;
        this.name = "TBC";
        this.location = "TBC";
        this.reviewsCollection = new ArrayList<>();        
    }

    /**
     *
     * @param name
     * @param location
     */
    public Restaurant(String name, String location) {
        this.id = ++lastIdAllocated;
        this.name = name;
        this.location = location;
        this.reviewsCollection = new ArrayList<>();
    }

    /**
     *
     * @param name
     * @param location
     * @param reviewsCollection
     */
    public Restaurant(String name, String location, List<Review> reviewsCollection) {
        this.id = ++lastIdAllocated;        
        this.name = name;
        this.location = location;
        this.reviewsCollection = reviewsCollection;
    }

    /**
     *
     * @param id
     * @param name
     * @param location
     * @param reviewsCollection
     */
    public Restaurant(int id, String name, String location, List<Review> reviewsCollection) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.reviewsCollection = reviewsCollection;
        if (id > Restaurant.lastIdAllocated)
            Restaurant.lastIdAllocated = id;            
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }    

    // Methods required: getters, setters, add, hashCode, equals, compareTo, comparator
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getLocation(){
        return location;
    }
    
    public void setLocation(String location){
        this.location = location;
    }
    
    public List getReviewsCollection(){
        return reviewsCollection;
    }
    
    public void setReviewsCollection(List<Review> reviewsCollection){
        this.reviewsCollection = reviewsCollection;
    }
    
    public void addReview(Review review) {
        this.reviewsCollection.add(review);
    }

    /**
     *
     * @return
     */
    
    @Override
    public String toString() {
        return "\nRestaurant Id: " + id + " - Name: " + name +            
                " - Location: " + location + "\nReviews: " + reviewsCollection + "\n";
    }    
    
//    public String toString(char delimiter) {
//        String output = "";
//        for (Customer item: this.items) {
//            output += item.toString(delimiter);
//        }
//        return output;
//    }
}

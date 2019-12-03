/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

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

    static final char EOLN = '\n';
    static final String QUOTE = "\"";

    /**
     *
     */
    // Compares one restaurant name with another and returns which is 'greater' or comes first.
    public static Comparator<Restaurant> RestaurantNameComparator
            = (Restaurant rest1, Restaurant rest2) -> {
                String restName1 = rest1.getName();
                String restName2 = rest2.getName();

                return restName1.compareTo(restName2);

            };

    /**
     *
     */
    /*
     Creates a restaurant with an ID 1 more than the previous allocated ID,
     a name and location which has to be set, and an empty list for the reviews
     to be added to.
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
    /*
     Creates a restaurant with an ID 1 more than the previous allocated ID,
     a name and location which has been passed in, and an empty list for the reviews
     to be added to.
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
    /*
     Creates a restaurant with an ID 1 more than the previous allocated ID,
     a name, location, and a list of reviews, which have all been passed in.
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
    /*
     Creates a restaurant with an ID, name, location, and a list of reviews, which
     have all been passed in.
     If the ID passed in is greater than the last ID that has been allocated then
     that ID which got passed in gets set to the last allocated ID.
     */
    public Restaurant(int id, String name, String location, List<Review> reviewsCollection) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.reviewsCollection = reviewsCollection;
        if (id > Restaurant.lastIdAllocated) {
            Restaurant.lastIdAllocated = id;
        }
    }

    /**
     * @return the id
     */
    // Returns the ID of the restaurant.
    public int getId() {
        return id;
    }

    // Returns the name of the restaurant.

    /**
     *
     * @return
     */
        public String getName() {
        return name;
    }

    // Sets the name of the restaurant with a name that has been passed in.

    /**
     *
     * @param name
     */
        public void setName(String name) {
        this.name = name;
    }

    // Returns the location of the restaurant.

    /**
     *
     * @return
     */
        public String getLocation() {
        return location;
    }

    // Sets the name of the location with a name that has been passed in.

    /**
     *
     * @param location
     */
        public void setLocation(String location) {
        this.location = location;
    }

    // Returns the list of reviews for the restaurant.

    /**
     *
     * @return
     */
        public List getReviewsCollection() {
        return reviewsCollection;
    }

    // Sets the reviews of the restautrant with a list of reviews that have been passed in.

    /**
     *
     * @param reviewsCollection
     */
        public void setReviewsCollection(List<Review> reviewsCollection) {
        this.reviewsCollection = reviewsCollection;
    }

    // Adds a review to the collection of reviews.

    /**
     *
     * @param review
     */
        public void addReview(Review review) {
        this.reviewsCollection.add(review);
    }

    /**
     *
     * @param o
     * @return
     */
    // Checks equality.
    @Override
    public boolean equals(Object o) {
        if (o instanceof Restaurant) {
            Restaurant e = (Restaurant) o;
            return e.getId() == getId()
                    && e.getId() == getId()
                    && e.getLocation().equals(getLocation())
                    && e.getReviewsCollection().equals(getReviewsCollection());
        } else {
            return false;
        }
    }

    /**
     *
     * @return
     */
    // Returns a hashcode.
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.location);
        hash = 53 * hash + Objects.hashCode(this.reviewsCollection);
        return hash;
    }

    /**
     *
     * @param compareCustomer
     * @return
     */
    // Compares
    public int compareTo(Restaurant compareCustomer) {
        int id = ((Restaurant) compareCustomer).getId();

        //ascending order
        return Restaurant.lastIdAllocated - id;
    }

    /**
     *
     * @return
     */
    // Returns the restaurant values as a string.
    @Override
    public String toString() {
        return "\nRestaurant Id: " + id + " - Name: " + name
                + " - Location: " + location + "\nReviews: " + reviewsCollection + "\n";
    }

    /**
     *
     * @param delimiter
     * @return
     */
    // Returns the restaurant values formatted as a string.
    public String toString(char delimiter) {
        String output = Integer.toString(this.id) + delimiter + QUOTE + this.name
                + QUOTE + delimiter + QUOTE + this.location + QUOTE + delimiter + this.reviewsCollection.size() + EOLN;
        for (Review review : this.reviewsCollection) {
            output += review.toString(delimiter);
        }
        return output;
    }

}

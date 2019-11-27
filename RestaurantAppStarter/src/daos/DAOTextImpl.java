/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import controllers.RestaurantController;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Restaurant;
import model.Review;
import repositories.Repository;

/**
 *
 * @author Zuby
 */
public class DAOTextImpl {

    public Repository load(String filename) throws IOException {
        char DELIMITER = ',';

        Repository repository;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            int restaurantID, numReviews;
            String restaurantName, restaurantLocation;
            

            String[] temp;
            String line = br.readLine();
            temp = line.split(Character.toString(DELIMITER));
            restaurantID = Integer.parseInt(temp[0]);
            restaurantName = stripQuotes(temp[1]);
            restaurantLocation = stripQuotes(temp[2]);

            numReviews = Integer.parseInt(temp[2]);
            ArrayList<Review> reviews = new ArrayList<>();
            Review newReview;
            for (int i = 0; i < numReviews; i++) {
                line = br.readLine();
                temp = line.split(Character.toString(DELIMITER));
                String reviewerName = stripQuotes(temp[0]);
                int rating = parseInt(stripQuotes(temp[1]));

                newReview = new Review(reviewerName, rating);
                reviews.add(newReview);
            }
            
            List<Restaurant> restaurant;
            restaurant = (List<Restaurant>) new Restaurant(restaurantID, restaurantName, restaurantLocation, reviews);
            return (Repository) restaurant;
        } catch (IOException ex) {
            Logger.getLogger(RestaurantController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void store(String filename, Repository aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String stripQuotes(String str) {
        return str.substring(1, str.length() - 1);
    }
}

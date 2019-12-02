/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
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

    static final char DELIMITER = ',';

    public Repository load(String filename) throws IOException {

        Repository repository = new Repository();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String[] temp;
            String line = br.readLine();

            while (line != null) {

                int restaurantID;
                int numReviews;
                String restaurantName;
                String restaurantLocation;

                temp = line.split(Character.toString(DELIMITER));
                restaurantID = Integer.parseInt(temp[0]);
                restaurantName = stripQuotes(temp[1]);
                restaurantLocation = stripQuotes(temp[2]);

                numReviews = Integer.parseInt(temp[3]);
                List<Review> reviews = new ArrayList<>();

                for (int i = 0; i < numReviews; i++) {
                    line = br.readLine();
                    temp = line.split(Character.toString(DELIMITER));
                    String reviewerName = stripQuotes(temp[0]);
                    int rating = parseInt(temp[1]);

                    Review review = new Review(reviewerName, rating);
                    reviews.add(review);
                }

                Restaurant restaurant = new Restaurant(restaurantID, restaurantName, restaurantLocation, reviews);
                repository.add(restaurant);
                line = br.readLine();

            }
            br.close();
        } catch (IOException ex) {
            System.out.println("Error! Could not load file.");
        }

        return repository;
    }

    public void store(String filename, Repository repository) {
        try (PrintWriter output = new PrintWriter(filename)) {
            output.print(repository.toString(DELIMITER));
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOTextImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String stripQuotes(String str) {
        return str.substring(1, str.length() - 1);
    }
}

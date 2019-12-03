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
import model.Restaurant;
import model.Review;
import repositories.Repository;

/**
 *
 * @author Zuby
 */
public class DAOTextImpl {

    static final char DELIMITER = ',';

    /**
     *
     * @param filename
     * @return
     * @throws IOException
     */
    /*
     Loads in the data from  a text file, which is passed in,
     and returns the data a repository object.
    
     If the text file can't be found it returns an error message.
     */
    public Repository load(String filename) throws IOException {

        Repository repository = new Repository();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String[] temp;
            String line = br.readLine();

            // Reads until the end of the text file
            while (line != null) {

                int restaurantID;
                int numReviews;
                String restaurantName;
                String restaurantLocation;

                // adds the line to a string array
                // first item in array is restaurant ID
                // second item in array is the restaurant name
                // third item in array is location of restaurant
                temp = line.split(Character.toString(DELIMITER));
                restaurantID = Integer.parseInt(temp[0]);
                restaurantName = stripQuotes(temp[1]);
                restaurantLocation = stripQuotes(temp[2]);

                // the number of reviews is the 4th item in the array
                numReviews = Integer.parseInt(temp[3]);
                List<Review> reviews = new ArrayList<>();

                /* loops through for the amount of reviews and adds the
                 reviewers name, which is first item, and the rating which is the
                 second item, and adds it to a list of reviews.
                 */
                for (int i = 0; i < numReviews; i++) {
                    line = br.readLine();
                    temp = line.split(Character.toString(DELIMITER));
                    String reviewerName = stripQuotes(temp[0]);
                    int rating = parseInt(temp[1]);

                    Review review = new Review(reviewerName, rating);
                    reviews.add(review);
                }

                /*the ID, name, location, and list of review is created into a
                 new restaurant object which is added into the repository item,
                 and loops to get all the restaurants in the text file.
                 */
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

    /**
     *
     * @param filename
     * @param repository
     */
    // passes in a filename and a repository object, and writes that object to a text file.
    public void store(String filename, Repository repository) {
        try (PrintWriter output = new PrintWriter(filename)) {
            output.print(repository.toString(DELIMITER));
            output.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error! Could not store file.");
        }
    }

    private String stripQuotes(String str) {
        return str.substring(1, str.length() - 1);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import helpers.InputHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import model.Restaurant;
import model.Review;
import repositories.Repository;

/**
 *
 * @author mga
 */
public class RestaurantController {

    private final Repository repository;

    /**
     *
     * @throws java.io.IOException
     */
    public RestaurantController() throws IOException {

        /*
         Asks if there is an already existing customer file,
         if yes it asks for the file name and reads in the file to a repository,
         if no it creates an empty repository
         */
        InputHelper inputHelper = new InputHelper();
        char c = inputHelper.readCharacter("Load an already existing Customers File (Y/N)?");
        if (c == 'Y' || c == 'y') {
            String fileName = inputHelper.readString("Enter filename");
            this.repository = new Repository(fileName);
        } else {
            this.repository = new Repository();
        }
    }

    /**
     *
     * @throws java.io.IOException
     */
    public void run() throws IOException {

        /*
         Displays a menu for the user, and depending on the users choice
         a different section of the code runs.
         A - runs addRestaurant() which lets you add a restaurant to
         your repository.
         B - runs addReview() which lets you add a review to a specific
         restaurant, and adds it to the repository.
         C - runs listLocationRestaurantDataInNameOrder() which lets you
         specify a location, and for only that location it lists them
         in order of the name.
         D - this quits the program, and saves the current repository to a text
         with your specified name.
         */
        boolean finished = false;

        do {
            char choice = displayMenu();
            switch (choice) {
                case 'A':
                    addRestaurant();
                    break;
                case 'B':
                    addReview();
                    break;
                case 'C':
                    listLocationRestaurantDataInNameOrder();
                    break;
                case 'D':
                    listRestaurantRatings();
                    break;
                case 'Q':

                    BufferedReader reader
                            = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter Filename? ");
                    String fileName = reader.readLine();
                    repository.store(fileName);
                    finished = true;

            }
        } while (!finished);
    }

    private char displayMenu() {

        /*
         Displays a menu for the user and opions to pick from, and returns
         the letter the user picked as that option.
         */
        listRestaurantDataInIdOrder();
        InputHelper inputHelper = new InputHelper();
        System.out.print("\nA. Add Restaurant");
        System.out.print("\tB. Add Restaurant Review");
        System.out.print("\tC. List Location Restaurant Data In Name Order");
        System.out.print("\tD. List Restaurant Ratings");
        System.out.print("\tQ. Quit\n");
        return inputHelper.readCharacter("Enter choice", "ABCDQ");
    }

    private void addRestaurant() throws IOException {

        /*
         Takes user input of name of restaurant and location, and creates a new
         restaurant object, and adds that to the repository.
         */
        System.out.format("\033[31m%s\033[0m%n", "Add Restaurant");
        System.out.format("\033[31m%s\033[0m%n", "==============");

        String restaurantName;
        String restaurantLocation;

        BufferedReader reader
                = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the name of the restaurant: ");
        restaurantName = reader.readLine();
        System.out.println("Enter the location of the restaurant: ");
        restaurantLocation = reader.readLine();

        Restaurant newRestaurant = new Restaurant(restaurantName, restaurantLocation);

        this.repository.add(newRestaurant);

    }

    private void addReview() throws IOException {

        /*
         Takes user input of the ID of the restaurant they want to add the review
         to, and then takes in the reviewer name and the rating of the review,
         then finally adds it onto that restaurant.
         */
        System.out.format("\033[31m%s\033[0m%n", "Add Restaurant Review");
        System.out.format("\033[31m%s\033[0m%n", "=====================");

        String reviewerName;
        int restaurantID;
        int rating;

        BufferedReader reader
                = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the ID of the restaurant:");
        restaurantID = parseInt((reader.readLine()));
        System.out.println("Enter reviewer name: ");
        reviewerName = reader.readLine();
        System.out.println("Enter rating: ");
        rating = parseInt((reader.readLine()));

        Review newReview = new Review(reviewerName, rating);

        List<Restaurant> repositoryItems = this.repository.getItems();

        Restaurant tempRestaurant = repositoryItems.get(restaurantID - 1);

        tempRestaurant.addReview(newReview);

    }

    private void listLocationRestaurantDataInNameOrder() throws IOException {

        /*
         Takes user input of a specific location, and then finds restaurants
         that fall under that location, sort it by name order, and then display
         */
        System.out.format("\033[31m%s\033[0m%n", "Name Order");
        System.out.format("\033[31m%s\033[0m%n", "==========");

        List<Restaurant> repositoryItems = this.repository.getItems();

        BufferedReader reader
                = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the location of the restaurant:");
        String location = reader.readLine();

        /*
         This section loads in all the restaurants, and then matches the
         user input against the location stored in te object, and if it matches
         then it adds the restaurant to a new list of restaurants.
         */
        List<Restaurant> newListRestaurant = new ArrayList<>();

        for (int i = 0; i < repositoryItems.size(); i++) {
            Restaurant getRestaurant = repositoryItems.get(i);
            String restaurantLoc = getRestaurant.getLocation();

            if (location.equals(restaurantLoc)) {
                newListRestaurant.add(getRestaurant);
            }

        }

        /*
         This takes that new list of restaurats and then sorts it by name order
         */
        Set<Restaurant> newSet = new TreeSet(Restaurant.RestaurantNameComparator);
        newSet.addAll(newListRestaurant);
        System.out.println(newSet);

    }

    private void listRestaurantRatings() {

        /*
         Gets the average rating for each restaurant and displays.
         */
        System.out.format("\033[31m%s\033[0m%n", "Restaurant Ratings");
        System.out.format("\033[31m%s\033[0m%n", "==================");

        List<Restaurant> repositoryItems = this.repository.getItems();

        /*
         Loads in every restaurant and loops through to calculate the average
         for that restaurant.
         */
        float averageRating;
        for (int i = 0; i < repositoryItems.size(); i++) {
            Restaurant restaurant = repositoryItems.get(i);

            List<Review> reviews = restaurant.getReviewsCollection();

            float numRating = 0;
            float totalRating = 0;

            /*
             For each review in the collection of reviews for a specific
             restaurant, it adds that individual review rating to a variable
             to keep track of the total review amount - for that restaurant
             */
            for (Review review : reviews) {

                totalRating += review.getRating();
                numRating++;

            }

            /*
             Calclates the average with the previous total of that restaurant
             by dividing it by the number of revews that are stored for that
             restaurant.
             Then it displays the name of the specific restaurant, and displays
             the average rating for that review.
             Loops through for each restaurant.
             */
            averageRating = totalRating / numRating;
            System.out.println((restaurant.getName()) + " has an average rating of: " + averageRating);
            System.out.println("");

        }

    }

    private void listRestaurantDataInIdOrder() {
        
        /*
        Since the restaurants are all stored in data order, it just gets the 
        restaurants and displays them.
        */
        System.out.format("\033[31m%s\033[0m%n", "Restaurant Id Order");
        System.out.format("\033[31m%s\033[0m%n", "===================");

        List<Restaurant> repositoryItems = this.repository.getItems();

        System.out.println(repositoryItems);

    }
}

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
import java.util.List;
import java.util.Scanner;
import model.Restaurant;
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
                    finished = true;
            }
        } while (!finished);
    }

    private char displayMenu() {
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
        System.out.format("\033[31m%s\033[0m%n", "Add Restaurant");
        System.out.format("\033[31m%s\033[0m%n", "==============");

        String restaurantName;
        String restaurantLocation;

        BufferedReader reader
                = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the name of the restaurant");
        restaurantName = reader.readLine();
        System.out.println("Enter the location of the restaurant");
        restaurantLocation = reader.readLine();
        
        Restaurant newRestaurant = new Restaurant(restaurantName, restaurantLocation);

        this.repository.add(newRestaurant);
    }

    private void addReview() {
        System.out.format("\033[31m%s\033[0m%n", "Add Restaurant Review");
        System.out.format("\033[31m%s\033[0m%n", "=====================");
    }

    private void listLocationRestaurantDataInNameOrder() {
        System.out.format("\033[31m%s\033[0m%n", "Name Order");
        System.out.format("\033[31m%s\033[0m%n", "==========");
    }

    private void listRestaurantRatings() {
        System.out.format("\033[31m%s\033[0m%n", "Restaurant Ratings");
        System.out.format("\033[31m%s\033[0m%n", "==================");
    }

    private void listRestaurantDataInIdOrder() {
        System.out.format("\033[31m%s\033[0m%n", "Restaurant Id Order");
        System.out.format("\033[31m%s\033[0m%n", "===================");

        List<Restaurant> repositoryItems = this.repository.getItems();

        System.out.println(repositoryItems);

    }
}

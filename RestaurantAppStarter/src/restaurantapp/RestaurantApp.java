/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantapp;

import controllers.RestaurantController;
import java.io.IOException;

/**
 *
 * @author mga
 */
public class RestaurantApp {

    /**
     *
     * @throws java.io.IOException
     */
    public static void run() throws IOException {    
        System.out.println("Restaurant Reviews App\n=====================\n\n");
        
        RestaurantController restaurantController = new RestaurantController();  
        
        restaurantController.run();
        
        System.out.println("Thank you for using Restaurant Reviews App. Good bye.\n");        
    }
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        RestaurantApp restaurantApp = new RestaurantApp();
        restaurantApp.run();
    }
}

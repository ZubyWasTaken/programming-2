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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.Review;
import repositories.Repository;

/**
 *
 * @author Zuby
 */
public class DAOTextImpl {

    public Repository load(String filename) throws IOException {
        char DELIMITER=',';
        String fileName;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) { 
            
            
            int restaurantID, numReviews;
            String restaurantName, restaurantLocation;
            

            String[] temp;
            String line = br.readLine(); 
            temp=line.split(Character.toString(DELIMITER));
            restaurantID = Integer.parseInt(temp[0]);            
            restaurantName = stripQuotes(temp[1]);
            restaurantLocation = stripQuotes(temp[2]); 
   
            
            numReviews = Integer.parseInt(temp[2]);
            ArrayList<Driver> namedDrivers = new ArrayList<>();
            Driver newDriver;
            for (int i=0; i<noDrivers; i++) {
                line = br.readLine();
                temp=line.split(Character.toString(DELIMITER));
                String firstName = stripQuotes(temp[0]);
                String surname = stripQuotes(temp[1]);                
                dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String dateOfBirthStr = stripQuotes(temp[2]);
                Date dateOfBirthDate;
                try {
                    dateOfBirthDate = dateFormat.parse(dateOfBirthStr);
                    dateOfBirth = Calendar.getInstance();
                    dateOfBirth.setTime(dateOfBirthDate);                
                } catch (ParseException ex) {
                    Logger.getLogger(PolicyController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                newDriver = new Driver(firstName, surname, dateOfBirth);
                namedDrivers.add(newDriver);
            }
            policy = new Policy(policyID, policyType, policyOwner, carReg, carDescription, policyStart, namedDrivers); 
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(PolicyController.class.getName()).log(Level.SEVERE, null, ex);
        }     
        }

    

    

    

    

    public void store(String filename, Repository aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String stripQuotes(String str) {
        return str.substring(1, str.length() - 1);
    }
}

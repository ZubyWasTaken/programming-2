/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import repositories.Repository;

/**
 *
 * @author Zuby
 */
public class DAOTextImpl {

    public Object load(String filename) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void store(String filename, Repository aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    private String stripQuotes(String str) {
        return str.substring(1, str.length()-1);
    }
}

package repositories;

import daos.DAOTextImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import model.Restaurant;

public class Repository implements RepositoryInterface {

    private List<Restaurant> items;

    public Repository() {
        this.items = new ArrayList<>();
        //this.items = new LinkedList<>();        
    }

    public Repository(List<Restaurant> items) {
        this.items = (List<Restaurant>) items;
    }

    public Repository(String filename) {
        this();
        DAOTextImpl dao = new DAOTextImpl();
//        this.items = dao.load(filename).getItems();         
    }

    @Override
    public List<Restaurant> getItems() {
        return this.items;
    }

    @Override
    public void setItems(List<Restaurant> items) {
        this.items = items;
    }

    @Override
    public void add(Restaurant item) {
        this.items.add(item);
    }

    @Override
    public void remove(int id) {
        Predicate<Restaurant> predicate = e -> e.getId() == id;
        this.items.removeIf(predicate);
    }

    @Override
    public Restaurant getItem(int id) {
        for (Restaurant item : this.items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "\nItems: " + this.items;
    }

//    public String toString(char delimiter) {
//        String output = this.items + delimiter + QUOTE + Integer.toString(this.rating) + EOLN;
//        return output;
//    }

    @Override
    public void store(String filename) {
        DAOTextImpl dao = new DAOTextImpl();
//        dao.store(filename, this);
    }
}

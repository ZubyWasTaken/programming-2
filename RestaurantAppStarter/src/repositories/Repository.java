package repositories;

import daos.DAOTextImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import model.Restaurant;

/**
 *
 * @author Zuby
 */
public class Repository implements RepositoryInterface {

    private List<Restaurant> items;

    /**
     *
     */
    // Creates a repository object which is empty.
    public Repository() {
        this.items = new ArrayList<>();
    }

    /**
     *
     * @param items
     */
    // Creates a repository object which has 'items' loaded as a list of Restaurants.
    public Repository(List<Restaurant> items) {
        this.items = items;
    }

    /**
     *
     * @param filename
     * @throws IOException
     */
    public Repository(String filename) throws IOException {
        this();
        DAOTextImpl dao = new DAOTextImpl();
        this.items = dao.load(filename).getItems();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Restaurant> getItems() {
        return this.items;
    }

    /**
     *
     * @param items
     */
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

    /**
     *
     * @param delimiter
     * @return
     */
    public String toString(char delimiter) {
        String output = "";
        for (Restaurant item : this.items) {
            output += item.toString(delimiter);
        }
        return output;
    }

    @Override
    public void store(String filename) {
        DAOTextImpl dao = new DAOTextImpl();
        dao.store(filename, this);
    }
}

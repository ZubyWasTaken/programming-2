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
    // Creates a repository by reading in a file and storing that data.
    public Repository(String filename) throws IOException {
        this();
        DAOTextImpl dao = new DAOTextImpl();
        this.items = dao.load(filename).getItems();
    }

    /**
     *
     * @return
     */
    // Returns the items in the repository object
    @Override
    public List<Restaurant> getItems() {
        return this.items;
    }

    /**
     *
     * @param items
     */
    // Sets the items in the repository object by passing a list of restaurants.
    @Override
    public void setItems(List<Restaurant> items) {
        this.items = items;
    }

    // Passes in a restaurant object to add to the repository of restaurants.
    @Override
    public void add(Restaurant item) {
        this.items.add(item);
    }

    // Removes a specific restaurant from the list of restaurants by a given ID.
    @Override
    public void remove(int id) {
        Predicate<Restaurant> predicate = e -> e.getId() == id;
        this.items.removeIf(predicate);
    }

    // Returns a specfic restaurant from the list of restaurants by a given ID.
    @Override
    public Restaurant getItem(int id) {
        for (Restaurant item : this.items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    // Returs the items as they're stored in the repository as a string.
    @Override
    public String toString() {
        return "\nItems: " + this.items;
    }

    /**
     *
     * @param delimiter
     * @return
     */
    // Formats the repository object with a given delimiter charachter.
    public String toString(char delimiter) {
        String output = "";
        for (Restaurant item : this.items) {
            output += item.toString(delimiter);
        }
        return output;
    }

    // Stores the repository object to a text file with a name that has been passed in.
    @Override
    public void store(String filename) {
        DAOTextImpl dao = new DAOTextImpl();
        dao.store(filename, this);
    }
}
